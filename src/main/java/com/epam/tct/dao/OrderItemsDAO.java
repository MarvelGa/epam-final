package com.epam.tct.dao;

import com.epam.tct.exception.DaoException;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;

public interface OrderItemsDAO {
    int createOrder(Order order, Item item, double distance) throws DaoException;
}
