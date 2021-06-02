package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.OrderItem;
import com.epam.tct.service.OrderItemsService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayOrders implements Command{
    private static final Logger log = Logger.getLogger(DisplayOrders.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
     List<OrderItem> orderItemList = orderItemsService.getOrders();
     request.setAttribute("orderItemList", orderItemList);
     return Path.ORDERS_VIEW;
    }
}
