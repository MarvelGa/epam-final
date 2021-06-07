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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAllUsersOrders implements Command {
    private static final Logger logger = Logger.getLogger(GetAllUsersOrders.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    public GetAllUsersOrders() {
    }

    public GetAllUsersOrders(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        HttpSession session = request.getSession();
        List<OrderItem> listUsersOrders = orderItemsService.getAllUsersOrders();
        session.setAttribute("listUsersOrders", listUsersOrders);
        logger.debug(String.format("forward --> %s", Path.ALL_USERS_ORDERS));
        logger.debug("Command finished");
        return Path.ALL_USERS_ORDERS;
    }
}
