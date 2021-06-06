package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.*;
import com.epam.tct.service.DistanceService;
import com.epam.tct.service.OrderItemsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PostCreateDeliveryTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);

    final HttpServletResponse response = mock(HttpServletResponse.class);
    @Mock
    private HttpSession session;
    @Mock
    private OrderItemsService orderItemsService;
    @Mock
    private DistanceService distanceService;

    @InjectMocks
    PostCreateDelivery command;

    private Distance dataDistance;
    private List<Distance> listDistance;
    private Order order;
    private Item item;
    private User user;
    private OrderItem orderItem;
    private List<OrderItem> listOrderItem;
    private List<Order> listOrder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new PostCreateDelivery(distanceService, orderItemsService);

        order = new Order();
        item = new Item();
        user = new User();
        orderItem = new OrderItem();
        listOrder = new ArrayList<>();
        listOrderItem = new ArrayList<>();

        order.setUser_id(2);
        order.setStatus(Order.OrderStatus.NEW);
        order.setCreatedAt(LocalDateTime.now());

        item = new Item();
        item.setCitySender(1);
        item.setCityRecipeint(2);
        item.setMaxWeight(10.5);
        item.setMaxLength(20.5);
        item.setMaxWidth(20.5);
        item.setMaxHeight(13.5);
        item.setPrice(200.5);
        item.setCreatedAt(LocalDateTime.now());

        user.setId(1);
        user.setEmail("ivanov@gmail.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPassword("1111");
        user.setRoleId(2);

        orderItem.setId(1);
        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setDistance(480.5);
        orderItem.setPrice(55.4);
        orderItem.setVolume(555.55);
        orderItem.setUser(user);

        listDistance = new ArrayList<>();
        dataDistance = new Distance();
        dataDistance.setId(1);
        dataDistance.setCityFrom("Kyiv");
        dataDistance.setCityFrom("Lviv");
        dataDistance.setDistance(480);
        listDistance.add(dataDistance);

        listOrder.add(order);
        listOrderItem.add(orderItem);
    }

    @Test
    void whenCallGPostCreateDeliveryCommandThanReturnUserOrderViewPage() throws ServletException, IOException, AppException {

        when(request.getMethod()).thenReturn("POST");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("weight")).thenReturn("10.2");
        when(request.getParameter("length")).thenReturn("20.5");
        when(request.getParameter("width")).thenReturn("15.2");
        when(request.getParameter("height")).thenReturn("10");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute(any(String.class))).thenReturn(user);
        when(orderItemsService.getOrders()).thenReturn(listOrderItem);
        when(distanceService.findById(1)).thenReturn(dataDistance);
        when(distanceService.getCityIdByName(dataDistance.getCityFrom())).thenReturn(1);
        when(distanceService.getCityIdByName(dataDistance.getCityTo())).thenReturn(2);
        when(orderItemsService.createOrder(order, item, dataDistance.getDistance())).thenReturn(1);
        String forward = command.execute(request, response);
        assertEquals(Path.COMMAND__USER_ORDER_VIEW, forward);
    }

}

