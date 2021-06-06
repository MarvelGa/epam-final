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
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PostChangeStatusDeliveryTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);
    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private OrderItemsService orderItemsService;

    @InjectMocks
    PostChangeStatusDelivery command;

    @BeforeEach
    void setUp()  {
        MockitoAnnotations.openMocks(this);
        command = new PostChangeStatusDelivery(orderItemsService);
    }

    @Test
    void whenCallPostChangeStatusDeliveryCommandThanReturnAllUsersOrdersPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getParameter("status")).thenReturn("NEW");
        when(request.getParameter("orderId")).thenReturn("1");
        String forward = command.execute(request, response);
        assertEquals(Path.COMMAND__ALL_USERS_ORDERS, forward);
    }
}
