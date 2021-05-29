package com.epam.tct.dao;

import com.epam.tct.exception.DaoException;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;

import java.util.List;

public interface OrderItemsDAO {
    int createOrder(Order order, Item item, double distance) throws DaoException;
    List<OrderItem> getAllDeliveriesOrdersByUserID(int id) throws DaoException;
    List<OrderItem> getAllUsersOrders() throws DaoException;
}
