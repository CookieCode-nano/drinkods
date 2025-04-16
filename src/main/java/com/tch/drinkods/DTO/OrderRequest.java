package com.tch.drinkods.DTO;

public class OrderRequest {
    private String drinkName;
    private String ordererName;
    private String customizations;

    public OrderRequest(String drinkName, String ordererName, String customizations) {
        this.drinkName = drinkName;
        this.ordererName = ordererName;
        this.customizations = customizations;
    }

    // Getters and Setters
    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getOrdererName() {
        return ordererName;
    }

    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    public String getCustomizations() {
        return customizations;
    }

    public void setCustomizations(String customizations) {
        this.customizations = customizations;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "drinkName='" + drinkName + '\'' +
                ", ordererName='" + ordererName + '\'' +
                ", customizations='" + customizations + '\'' +
                '}';
    }
}