package com.epam.tct.service;

import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;
import com.epam.tct.model.User;

public interface OrderItemsService {
   int createOrder(Order order, Item item, double distance)throws ServiceException;
}
