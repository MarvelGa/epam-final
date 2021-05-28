package com.epam.tct.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Item {
    private int id;
    private int citySender;
    private int cityRecipeint;
    private String cityFrom;
    private String cityTo;
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

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && citySender == item.citySender && cityRecipeint == item.cityRecipeint && cityFrom.equals(item.cityFrom) && cityTo.equals(item.cityTo) && maxWeight.equals(item.maxWeight) && maxLength.equals(item.maxLength) && maxWidth.equals(item.maxWidth) && maxHeight.equals(item.maxHeight) && price.equals(item.price) && createdAt.equals(item.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, citySender, cityRecipeint, cityFrom, cityTo, maxWeight, maxLength, maxWidth, maxHeight, price, createdAt);
    }
}
