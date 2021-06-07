package com.epam.tct.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    public enum OrderStatus {
        NEW, PENDING, COMPLETE, CANCELED
    }

    private int id;
    private int userId;
    private OrderStatus status = OrderStatus.NEW;
    private LocalDateTime createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        return id == order.id && userId == order.userId && status == order.status && createdAt.equals(order.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, createdAt);
    }
}
