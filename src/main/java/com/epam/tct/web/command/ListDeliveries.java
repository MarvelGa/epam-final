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

public class ListDeliveries implements Command {
    private static final Logger logger = Logger.getLogger(ListDeliveries.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    public ListDeliveries() {
    }

    public ListDeliveries(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        int userID = Integer.parseInt(request.getParameter("userId"));
        List<OrderItem> orderItemList = orderItemsService.getAllDeliveriesOrdersByUserID(userID);
        request.setAttribute("listOfUsersOrders", orderItemList);
        logger.debug(String.format("forward --> %s", Path.GET_LIST_OF_USER_ORDERS));
        logger.debug("Command finished");
        return Path.GET_LIST_OF_USER_ORDERS;
    }
}
