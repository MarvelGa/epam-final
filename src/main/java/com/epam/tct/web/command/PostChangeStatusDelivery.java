package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Order;
import com.epam.tct.service.OrderItemsService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PostChangeStatusDelivery implements Command {
    private static final Logger logger = Logger.getLogger(PostChangeStatusDelivery.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    public PostChangeStatusDelivery() {
    }

    public PostChangeStatusDelivery(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        Order.OrderStatus status = Order.OrderStatus.valueOf(request.getParameter("status"));
        int orderId = Integer.valueOf(request.getParameter("orderId"));
        orderItemsService.updateOrderStatusByOrderId(status, orderId);
        logger.debug(String.format("redirect --> %s", Path.COMMAND__ALL_USERS_ORDERS));
        logger.debug("Command finished");
        return Path.COMMAND__ALL_USERS_ORDERS;
    }
}
