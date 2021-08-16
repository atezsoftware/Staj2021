package com.atez.inventory.manager.entity;

public class UserInventoryHistoryEntity {
    String userId;
    String firstName;
    String lastName;
    private String inventoryName;
    private String serialNumber;
    private String categoryName;

    public UserInventoryHistoryEntity(String userId, String firstName, String lastName, String inventoryName, String serialNumber, String categoryName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.inventoryName = inventoryName;
        this.serialNumber = serialNumber;
        this.categoryName = categoryName;
    }

    public UserInventoryHistoryEntity() {

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

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
