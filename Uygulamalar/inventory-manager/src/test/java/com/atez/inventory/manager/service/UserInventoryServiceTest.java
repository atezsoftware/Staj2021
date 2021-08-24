package com.atez.inventory.manager.service;

import com.atez.inventory.manager.entity.InventoryEntity;
import com.atez.inventory.manager.entity.UserEntity;
import com.atez.inventory.manager.entity.UserInventoryEntity;
import com.atez.inventory.manager.repository.UserInventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("Inventory User Service Test")
class UserInventoryServiceTest {

    @InjectMocks
    UserInventoryService userInventoryService;

    @Mock
    UserInventoryRepository userInventoryRepository;

    UserInventoryEntity userInventoryEntity;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setName("Dell XPS");

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname("Tuncay");
        userEntity.setLastname("Uzun");

        userInventoryEntity = new UserInventoryEntity();
        userInventoryEntity.setStatus("Active");
        userInventoryEntity.setUser(userEntity);
        userInventoryEntity.setInventory(inventoryEntity);
    }

    @Test
    @DisplayName("Find inventory by id")
    void findById() {
        when(userInventoryRepository.findById("123")).thenReturn(java.util.Optional.ofNullable(userInventoryEntity));

        UserInventoryEntity inventoryFromSource = userInventoryService.findById("123");

        assertAll("Verify/check user inventory",
                () -> assertThat("Tuncay", equalTo(inventoryFromSource.getUser().getFirstname())),
                () -> assertThat("Dell XPS", equalTo(inventoryFromSource.getInventory().getName()))
        );

    }
}