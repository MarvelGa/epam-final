package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.exception.ServiceException;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class GetUserCabinetTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);
    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private DistanceService distanceService;

    @Mock
    private HttpSession session;

    @InjectMocks
    GetUserCabinet command;
    private Distance dataDistance;
    private List<Distance> listDistance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new GetUserCabinet(distanceService);
        listDistance = new ArrayList<>();
        dataDistance = new Distance();
        dataDistance.setId(1);
        dataDistance.setCityFrom("Kyiv");
        dataDistance.setCityFrom("Lviv");
        dataDistance.setDistance(480);
        listDistance.add(dataDistance);
    }

    @Test
    void whenCallGetUserCabinetCommandThanReturnUserCabinetPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("GET");
        when(request.getSession(false)).thenReturn(session);
        when(distanceService.findAll()).thenReturn(listDistance);
        String forward = command.execute(request, response);
        assertEquals(Path.USER_CABINET, forward);
    }

    @Test
    void whenCallTheCommandAndThrowServiceException() {
        try {
            when(distanceService.findAll()).thenThrow(ServiceException.class);
            when(request.getMethod()).thenReturn("GET");
            command.execute(request, response);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
