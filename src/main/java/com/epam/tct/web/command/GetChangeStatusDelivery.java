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
    private static final Logger log = Logger.getLogger(GetChangeStatusDelivery.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        int orderId = Integer.valueOf(request.getParameter("id"));
        OrderItem orderItem = orderItemsService.getDeliveryOrderItemByOrderId(orderId);
        request.setAttribute("orderItem", orderItem );
        return Path.USER_ORDER_VIEW;
    }
}