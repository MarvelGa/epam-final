package com.epam.tct.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    public enum OrderStatus {
        NEW, PENDING, COMPLETE, CANCELED
    }

    private int id;
    private int user_id;
    private OrderStatus status = OrderStatus.NEW;
    private LocalDateTime createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && user_id == order.user_id && status == order.status && createdAt.equals(order.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, status, createdAt);
    }
}
