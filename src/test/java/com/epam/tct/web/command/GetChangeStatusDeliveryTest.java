package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.exception.ServiceException;
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
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetChangeStatusDeliveryTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);

    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private OrderItemsService orderItemsService;

    @InjectMocks
    GetChangeStatusDelivery command;

    private Order order;
    private Item item;
    private User user;
    private OrderItem orderItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new GetChangeStatusDelivery(orderItemsService);

        order = new Order();
        item = new Item();
        user = new User();
        orderItem = new OrderItem();

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

    }

    @Test
    void whenCallGetChangeStatusDeliveryCommandThanReturnUserOrderViewPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("GET");
        when(request.getParameter("id")).thenReturn("1");
        when(orderItemsService.getDeliveryOrderItemByOrderId(1)).thenReturn(orderItem);
        String forward = command.execute(request, response);
        assertEquals(Path.USER_ORDER_VIEW, forward);
        verify(request, times(1)).setAttribute("orderItem", orderItem);
    }

    @Test
    void whenCallTheCommandAndThrowServiceException() {
        try {
            when(orderItemsService.getDeliveryOrderItemByOrderId(1)).thenThrow(ServiceException.class);
            when(request.getMethod()).thenReturn("GET");
            command.execute(request, response);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
