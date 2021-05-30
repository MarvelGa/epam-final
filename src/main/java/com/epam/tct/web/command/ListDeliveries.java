package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.OrderItem;
import com.epam.tct.model.User;
import com.epam.tct.service.OrderItemsService;
import com.epam.tct.service.UserService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListDeliveries implements Command {
    private static final Logger log = Logger.getLogger(AllUserDeliveries.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        int userID = Integer.parseInt(request.getParameter("userId"));
        List<OrderItem> orderItemList = orderItemsService.getAllDeliveriesOrdersByUserID(userID);
        request.setAttribute("listOfUsersOrders", orderItemList);
        return Path.GET_LIST_OF_USER_ORDERS;
    }


}
