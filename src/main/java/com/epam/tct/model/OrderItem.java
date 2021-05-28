package com.epam.tct.model;

import java.util.Objects;

public class OrderItem {
    private int id;
    private Order order;
    private Item item;
    private double distance;
    private double price;
    private double volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id == orderItem.id && Double.compare(orderItem.distance, distance) == 0 && Double.compare(orderItem.price, price) == 0 && Double.compare(orderItem.volume, volume) == 0 && order.equals(orderItem.order) && item.equals(orderItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, item, distance, price, volume);
    }
}
