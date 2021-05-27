package com.epam.tct.model;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private int citySender;
    private int cityRecipeint;
    private Double maxWeight;
    private Double maxLength;
    private Double maxWidth;
    private Double maxHeight;
    private Double price;
    private LocalDateTime createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCitySender() {
        return citySender;
    }

    public void setCitySender(int citySender) {
        this.citySender = citySender;
    }

    public int getCityRecipeint() {
        return cityRecipeint;
    }

    public void setCityRecipeint(int cityRecipeint) {
        this.cityRecipeint = cityRecipeint;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Double maxLength) {
        this.maxLength = maxLength;
    }

    public Double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
