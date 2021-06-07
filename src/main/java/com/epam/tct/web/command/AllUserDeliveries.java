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

public class AllUserDeliveries implements Command {
    private static final Logger logger = Logger.getLogger(AllUserDeliveries.class);
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    public AllUserDeliveries() {
    }

    public AllUserDeliveries(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItemList = orderItemsService.getAllDeliveriesOrdersByUserID(user.getId());
        session.setAttribute("allUserOrders", orderItemList);
        logger.debug(String.format("forward --> %s", Path.USER_All_ORDERS));
        logger.debug("Command finished");
        return Path.USER_All_ORDERS;
    }
}
