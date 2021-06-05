package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Distance;
import com.epam.tct.service.DistanceService;
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


public class GetCreateDeliveryTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);
    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private DistanceService distanceService;

    @InjectMocks
    GetCreateDelivery command;
    private Distance dataDistance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new GetCreateDelivery(distanceService);

        dataDistance = new Distance();
        dataDistance.setId(1);
        dataDistance.setCityFrom("Kyiv");
        dataDistance.setCityFrom("Lviv");
        dataDistance.setDistance(480);

    }

    @Test
    void whenGetCreateDeliveryCommandThanReturnCreatDeliveryPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("GET");
        when(request.getParameter("id")).thenReturn("1");
        when(distanceService.findById(1)).thenReturn(dataDistance);
        String forward = command.execute(request, response);
        assertEquals(Path.CREATE_DELIVERY, forward);
        verify(request, times(1)).setAttribute("distance", dataDistance);
    }
}
