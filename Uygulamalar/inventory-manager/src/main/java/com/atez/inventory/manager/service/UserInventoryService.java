package com.atez.inventory.manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.atez.inventory.manager.dto.InventoryHistoryDTO;
import com.atez.inventory.manager.dto.UserInventoryHistoryDTO;
import com.atez.inventory.manager.entity.UserInventoryHistoryEntity;
import com.atez.inventory.manager.repository.SqlQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.atez.inventory.manager.dto.UserInventoryDTO;
import com.atez.inventory.manager.entity.InventoryEntity;
import com.atez.inventory.manager.entity.UserEntity;
import com.atez.inventory.manager.entity.UserInventoryEntity;
import com.atez.inventory.manager.exception.CustomException;
import com.atez.inventory.manager.exception.ErrorCodes;
import com.atez.inventory.manager.repository.UserInventoryRepository;

@Service
public class UserInventoryService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private UserInventoryRepository userInventoryRepository;

    @Autowired
    private UserService userService;


    @Autowired
    private InventoryService inventoryService;

    public UserInventoryEntity save(@Valid UserInventoryDTO userInventoryDTO) {
        InventoryEntity inventory = inventoryService.findById(userInventoryDTO.getInventoryId());
        UserEntity user = userService.findByUsernameFromKeycloak(userInventoryDTO.getUserId());

        Optional<UserInventoryEntity> userInventoryOpt = userInventoryRepository.findByUserIdAndInventoryId(user.getId(), userInventoryDTO.getInventoryId());
        if (userInventoryOpt.isPresent()) {
            throw new CustomException(ErrorCodes.INVENTORY_ALREADY_ASSINGED);
        }

        UserInventoryEntity userIveInventoryEntity = new UserInventoryEntity();
        userIveInventoryEntity.setInventory(inventory);
        userIveInventoryEntity.setUser(user);
        userIveInventoryEntity.setStatus("ACTIVE");

        return save(userIveInventoryEntity);
    }


    public UserInventoryEntity save(@Valid UserInventoryEntity userInventoryEntity) {
        return userInventoryRepository.save(userInventoryEntity);
    }

    public List<UserInventoryEntity> findAll() {
        return userInventoryRepository.findAll();
    }

    public UserInventoryEntity findById(String id) {
        return userInventoryRepository.findById(id).orElse(null);
    }

    public UserInventoryHistoryDTO findUserInventoryHistory(String userId) {
        return multiTransactionHistory(userId);
        //return oneTransactionHistory(userId);

    }

    private UserInventoryHistoryDTO multiTransactionHistory(String userId) {
        UserEntity userEntity = userService.findUserById(userId);
        List<UserInventoryEntity> userInventoryList = userInventoryRepository.findAllByUser(userEntity);
        UserInventoryHistoryDTO userInventoryHistory = new UserInventoryHistoryDTO();
        userInventoryHistory.setUserId(userEntity.getKeyCloakId());
        userInventoryHistory.setFirstName(userEntity.getFirstname());
        userInventoryHistory.setLastName(userEntity.getLastname());
        List<InventoryHistoryDTO> inventoryHistoryList = new ArrayList<>();
        for (UserInventoryEntity userInventoryEntity : userInventoryList) {
            InventoryHistoryDTO inventoryHistoryDTO = new InventoryHistoryDTO();
            inventoryHistoryDTO.setInventoryName(userInventoryEntity.getInventory().getName());
            inventoryHistoryDTO.setSerialNumber(userInventoryEntity.getInventory().getSerialNumber());
            inventoryHistoryDTO.setCategoryName(userInventoryEntity.getInventory().getCategoryType().getName());
            inventoryHistoryList.add(inventoryHistoryDTO);
        }
        userInventoryHistory.setInventoryList(inventoryHistoryList);
        return userInventoryHistory;
    }

    private UserInventoryHistoryDTO oneTransactionHistory(String userId) {
        List<UserInventoryHistoryEntity> inventoryHistoryEntityList = jdbcTemplate.query(SqlQueries.getUserInventoryReportSql(), new Object[]{userId}, (rs, rowNum) -> new UserInventoryHistoryEntity(
                        rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("name"),
                        rs.getString("serail_number"),
                        rs.getString("name")
                )
        );


        List<InventoryHistoryDTO> inventoryHistoryList = new ArrayList<>();
        for (UserInventoryHistoryEntity entity : inventoryHistoryEntityList) {
            InventoryHistoryDTO inventoryHistoryDTO = new InventoryHistoryDTO();
            inventoryHistoryDTO.setInventoryName(entity.getInventoryName());
            inventoryHistoryDTO.setSerialNumber(entity.getLastName());
            inventoryHistoryDTO.setCategoryName(entity.getCategoryName());
            inventoryHistoryDTO.setSerialNumber(entity.getSerialNumber());
            inventoryHistoryList.add(inventoryHistoryDTO);
        }

        UserInventoryHistoryDTO userInventoryHistory = new UserInventoryHistoryDTO();
        userInventoryHistory.setUserId(inventoryHistoryEntityList.get(0).getUserId());
        userInventoryHistory.setFirstName(inventoryHistoryEntityList.get(0).getFirstName());
        userInventoryHistory.setLastName(inventoryHistoryEntityList.get(0).getLastName());
        userInventoryHistory.setInventoryList(inventoryHistoryList);
        return userInventoryHistory;
    }


}
