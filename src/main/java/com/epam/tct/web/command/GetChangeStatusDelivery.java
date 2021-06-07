package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Distance;
import com.epam.tct.model.OrderItem;
import com.epam.tct.service.OrderItemsService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetChangeStatusDelivery implements Command {
    private static final Logger logger = Logger.getLogger(GetChangeStatusDelivery.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    public GetChangeStatusDelivery() {
    }

    public GetChangeStatusDelivery(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        int orderId = Integer.valueOf(request.getParameter("id"));
        OrderItem orderItem = orderItemsService.getDeliveryOrderItemByOrderId(orderId);
        request.setAttribute("orderItem", orderItem);
        logger.debug(String.format("forward --> %s", Path.USER_ORDER_VIEW));
        logger.debug("Command finished");
        return Path.USER_ORDER_VIEW;
    }
}
