package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.*;
import com.epam.tct.service.DistanceService;
import com.epam.tct.service.OrderItemsService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostCreateDelivery implements Command {
    private static final Logger log = Logger.getLogger(PostCreateDelivery.class);
    private DistanceService distanceService = ServiceFactory.getInstance().getDistanceService();
    private OrderItemsService orderItemsService = ServiceFactory.getInstance().getOrderItemsService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        int id = Integer.valueOf(request.getParameter("id"));
        Double weight = Double.valueOf(request.getParameter("weight"));
        Double length = Double.valueOf(request.getParameter("length"));
        Double width = Double.valueOf(request.getParameter("width"));
        Double height = Double.valueOf(request.getParameter("height"));


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Distance data = distanceService.findById(id);
        Double volume = getRoundOffTheNumber(length * width * height);
        Double price = getRoundOffTheNumber(volume * data.getDistance()/ (double) 3);

        int cityFromId = distanceService.getCityIdByName(data.getCityFrom());
        int cityToId = distanceService.getCityIdByName(data.getCityTo());
        Order order = new Order();
        order.setUser_id(user.getId());
        order.setCreatedAt(LocalDateTime.now());
        Item item = new Item();
        item.setCityFrom(data.getCityFrom());
        item.setCityTo(data.getCityTo());
        item.setCitySender(cityFromId);
        item.setCityRecipeint(cityToId);
        item.setMaxWeight(weight);
        item.setMaxLength(length);
        item.setMaxWidth(width);
        item.setMaxHeight(height);
        item.setPrice(price);
        item.setCreatedAt(LocalDateTime.now());

        int orderItemId = orderItemsService.createOrder(order, item, data.getDistance());

        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemId);
        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setDistance(data.getDistance());
        orderItem.setVolume(volume);
        List<OrderItem> list = new ArrayList<>();
        list.add(orderItem);
        request.setAttribute("orderItems", list);
        session.setAttribute("orderItems", list);
        return Path.COMMAND__USER_ORDER_VIEW;
    }

    static Double getRoundOffTheNumber(Double value){
        double scale = Math.pow(10, 2);
        return Math.ceil(value * scale) / scale;
    }
}
