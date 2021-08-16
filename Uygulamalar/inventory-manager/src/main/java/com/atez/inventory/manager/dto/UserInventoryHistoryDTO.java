package com.atez.inventory.manager.dto;

import java.util.List;



public class UserInventoryHistoryDTO {
    String userId;
    String firstName;
    String lastName;
    List<InventoryHistoryDTO> inventoryList;

    public UserInventoryHistoryDTO(String userId, String firstName, String lastName, List<InventoryHistoryDTO> inventoryList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.inventoryList = inventoryList;
    }

    public UserInventoryHistoryDTO() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<InventoryHistoryDTO> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<InventoryHistoryDTO> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
