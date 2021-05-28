package com.epam.tct.service.impl;

import com.epam.tct.dao.DistanceDAO;
import com.epam.tct.dao.OrderItemsDAO;
import com.epam.tct.dao.impl.DaoFactory;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.Distance;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;
import com.epam.tct.service.OrderItemsService;
import org.apache.log4j.Logger;

public class OrderItemsServiceImpl implements OrderItemsService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private OrderItemsDAO orderItemsDAO = daoFactory.getOrderItemsDAO();
    private static final Logger logger = Logger.getLogger(OrderItemsServiceImpl.class);

    @Override
    public int createOrder(Order order, Item item, double distance) throws ServiceException {
        try {
            return orderItemsDAO.createOrder(order, item, distance);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_CREATE_ORDER, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_CREATE_ORDER, e);
        }
    }
}