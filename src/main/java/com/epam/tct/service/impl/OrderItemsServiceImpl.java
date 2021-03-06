package com.epam.tct.service.impl;

import com.epam.tct.dao.OrderItemsDAO;
import com.epam.tct.dao.impl.DaoFactory;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;
import com.epam.tct.service.OrderItemsService;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderItemsServiceImpl implements OrderItemsService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private OrderItemsDAO orderItemsDAO = daoFactory.getOrderItemsDAO();
    private static final Logger logger = Logger.getLogger(OrderItemsServiceImpl.class);

    public OrderItemsServiceImpl() {
    }

    public OrderItemsServiceImpl(OrderItemsDAO orderItemsDAO) {
        this.orderItemsDAO = orderItemsDAO;
    }

    @Override
    public int createOrder(Order order, Item item, double distance) throws ServiceException {
        try {
            return orderItemsDAO.createOrder(order, item, distance);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_CREATE_ORDER, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_CREATE_ORDER, e);
        }
    }

    @Override
    public List<OrderItem> getAllDeliveriesOrdersByUserID(int id) throws ServiceException {
        try {
            return orderItemsDAO.getAllDeliveriesOrdersByUserID(id);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_GET_ALL_ORDERS_BY_USER_ID, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_GET_ALL_ORDERS_BY_USER_ID, e);
        }
    }

    @Override
    public List<OrderItem> getAllUsersOrders() throws ServiceException {
        try {
            return orderItemsDAO.getAllUsersOrders();
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_GET_ALL_USERS_ORDER, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_GET_ALL_USERS_ORDER, e);
        }
    }

    @Override
    public boolean updateOrderStatusByOrderId(Order.OrderStatus status, int orderId) throws ServiceException {
        try {
            return orderItemsDAO.updateOrderStatusByOrderId(status, orderId);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_UPDATE_ORDER_STATUS_BY_ORDER_ID, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_UPDATE_ORDER_STATUS_BY_ORDER_ID, e);
        }
    }

    @Override
    public OrderItem getDeliveryOrderItemByOrderId(int orderId) throws ServiceException {
        try {
            return orderItemsDAO.getDeliveryOrderItemByOrderId(orderId);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_GET_USER_ORDER_BY_ORDER_ID, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_GET_USER_ORDER_BY_ORDER_ID, e);
        }
    }

    @Override
    public List<OrderItem> getOrders() throws ServiceException {
        try {
            return orderItemsDAO.getOrders();
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_GET_ORDERS, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_GET_ORDERS, e);
        }
    }
}
