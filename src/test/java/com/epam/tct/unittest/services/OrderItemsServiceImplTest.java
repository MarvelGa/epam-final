package com.epam.tct.unittest.services;

import com.epam.tct.dao.OrderItemsDAO;
import com.epam.tct.exception.DaoException;
import com.epam.tct.model.*;
import com.epam.tct.service.OrderItemsService;
import com.epam.tct.service.impl.OrderItemsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderItemsServiceImplTest {
    @Mock
    final OrderItemsDAO orderItemsDAO = mock(OrderItemsDAO.class);
    OrderItemsService service;

    private Order order;
    private Item item;
    private User user;
    private OrderItem orderItem;
    private List<OrderItem> listOrderItem;
    private List<Order> listOrder;
    private double distance = 480;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new OrderItemsServiceImpl(orderItemsDAO);
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
        orderItem.setDistance(distance);
        orderItem.setPrice(55.4);
        orderItem.setVolume(555.55);
        orderItem.setUser(user);

        listOrder.add(order);
        listOrderItem.add(orderItem);
    }

    @Test
    void shouldCreateOrder() {
        try {
            when(orderItemsDAO.createOrder(order, item, distance)).thenReturn(1);
            int expected = 1;
            int actual = service.createOrder(order, item, distance);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryCreateOrderThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(orderItemsDAO).createOrder(order, item, distance);
            service.createOrder(order, item, distance);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetAllDeliveriesOrdersByUserID() {
        try {
            when(orderItemsDAO.getAllDeliveriesOrdersByUserID(1)).thenReturn(listOrderItem);
            List<OrderItem> expected = listOrderItem;
            List<OrderItem> actual = service.getAllDeliveriesOrdersByUserID(1);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenGetAllDeliveriesOrdersByUserIDThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(orderItemsDAO).getAllDeliveriesOrdersByUserID(1);
            service.getAllDeliveriesOrdersByUserID(1);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetAllUsersOrders() {
        try {
            when(orderItemsDAO.getAllUsersOrders()).thenReturn(listOrderItem);
            List<OrderItem> expected = listOrderItem;
            List<OrderItem> actual = service.getAllUsersOrders();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenGetAllUsersOrdersThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(orderItemsDAO).getAllUsersOrders();
            service.getAllUsersOrders();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldUpdateOrderStatusByOrderId() {
        try {
            when(orderItemsDAO.updateOrderStatusByOrderId(Order.OrderStatus.NEW, 1)).thenReturn(true);
            boolean expected = true;
            boolean actual = service.updateOrderStatusByOrderId(Order.OrderStatus.NEW, 1);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenUpdateOrderStatusByOrderIdThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(orderItemsDAO).updateOrderStatusByOrderId(Order.OrderStatus.NEW, 1);
            service.updateOrderStatusByOrderId(Order.OrderStatus.NEW, 1);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetDeliveryOrderItemByOrderId() {
        try {
            when(orderItemsDAO.getDeliveryOrderItemByOrderId(1)).thenReturn(orderItem);
            OrderItem expected = orderItem;
            OrderItem actual = service.getDeliveryOrderItemByOrderId(1);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenGetDeliveryOrderItemByOrderIdThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(orderItemsDAO).getDeliveryOrderItemByOrderId(1);
            service.getDeliveryOrderItemByOrderId(1);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetOrders() {
        try {
            when(orderItemsDAO.getOrders()).thenReturn(listOrderItem);
            List<OrderItem> expected = listOrderItem;
            List<OrderItem> actual = service.getOrders();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenShouldGetOrdersThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(orderItemsDAO).getOrders();
            service.getOrders();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
