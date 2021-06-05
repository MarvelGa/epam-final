package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;
import com.epam.tct.model.User;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class GetAllUsersOrdersTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);

    final HttpServletResponse response = mock(HttpServletResponse.class);
    @Mock
    private HttpSession session;
    @Mock
    private OrderItemsService orderItemsService;

    @InjectMocks
    GetAllUsersOrders command;

    private Order order;
    private Item item;
    private User user;
    private OrderItem orderItem;
    private List<OrderItem> listOrderItem;
    private List<Order> listOrder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new GetAllUsersOrders(orderItemsService);

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

        listOrder.add(order);
        listOrderItem.add(orderItem);
    }

    @Test
    void whenCallGetAllUsersOrdersCommandThanReturnAllUsersOrdersPage() throws ServletException, IOException, AppException {
        when(request.getSession()).thenReturn(session);
        when(request.getMethod()).thenReturn("GET");
        when(orderItemsService.getOrders()).thenReturn(listOrderItem);
        String forward = command.execute(request, response);
        assertEquals(Path.ALL_USERS_ORDERS, forward);
        verify(request, never()).setAttribute(anyString(), any(OrderItem.class));
    }
}
