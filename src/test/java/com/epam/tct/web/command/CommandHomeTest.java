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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class CommandHomeTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);

    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private DistanceService distanceService;

    @InjectMocks
    CommandHome command;
    private Distance dataDistance;
    private List<Distance> listDistance;

    @BeforeEach
    void setUp()  {
        MockitoAnnotations.openMocks(this);
        command = new CommandHome(distanceService);
        listDistance = new ArrayList<>();
        dataDistance = new Distance();
        dataDistance.setId(1);
        dataDistance.setCityFrom("Kyiv");
        dataDistance.setCityFrom("Lviv");
        dataDistance.setDistance(480);
        listDistance.add(dataDistance);
    }

    @Test
    void whenCallHomeCommandThanReturnHomePage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("GET");
        when(distanceService.findAll()).thenReturn(listDistance);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__HOME, forward);
        verify(request, never()).setAttribute(anyString(), any(Distance.class));
    }
}
