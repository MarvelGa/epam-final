package com.epam.tct.service;

import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;
import com.epam.tct.model.User;

import java.util.List;

public interface OrderItemsService {
   int createOrder(Order order, Item item, double distance)throws ServiceException;
   List<OrderItem> getAllDeliveriesOrdersByUserID(int id) throws ServiceException;
   List<OrderItem> getAllUsersOrders() throws ServiceException;
   boolean updateOrderStatusByOrderId(Order.OrderStatus status, int orderId) throws ServiceException;
   OrderItem getDeliveryOrderItemByOrderId(int orderId) throws ServiceException;
   List<OrderItem> getOrders() throws  ServiceException;
}
