package com.atez.inventory.manager.controller;

import com.atez.inventory.manager.entity.InventoryEntity;
import com.atez.inventory.manager.entity.UserEntity;
import com.atez.inventory.manager.entity.UserInventoryEntity;
import com.atez.inventory.manager.service.UserInventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("User Inventory Controller Test")
@SpringBootTest
@AutoConfigureMockMvc
class UserInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserInventoryService userInventoryService;

    private UserInventoryEntity userInventoryEntity;
    private List<UserInventoryEntity> userInventoryEntityList;

    @BeforeEach
    void setup(){
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setName("Dell XPS");

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname("Tuncay");
        userEntity.setLastname("Uzun");

        userInventoryEntity = new UserInventoryEntity();
        userInventoryEntity.setStatus("Active");
        userInventoryEntity.setUser(userEntity);
        userInventoryEntity.setInventory(inventoryEntity);

        userInventoryEntityList = List.of(userInventoryEntity);
    }

    @Test
    @DisplayName("Get user inventory list")
    @WithMockUser(username = "tuncay", password = "123454", roles = "USER")
    void get() throws Exception {
        when(userInventoryService.findAll()).thenReturn(userInventoryEntityList);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/v1/api/user-inventories")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.[0].status", is("Active")))
                .andExpect(jsonPath("$.[0].inventory.name", is("Dell XPS")))
                .andReturn();

        verify(userInventoryService, times(1)).findAll();
    }
}