package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
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
import static org.mockito.Mockito.*;

public class DisplayAllUsersTest {

    final HttpServletRequest request = mock(HttpServletRequest.class);

    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private UserService userService;


    @InjectMocks
    DisplayAllUsers command;
    private User user;
    private List<User> listUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new DisplayAllUsers(userService);
        listUser = new ArrayList();
        user = new User();
        user.setId(1);
        user.setEmail("ivanov@gmail.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPassword("1111");
        user.setRoleId(2);
        listUser.add(user);

    }

    @Test
    void whenCallDisplayAllUsersCommandThanReturnDisplayAllUsersPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("GET");
        when(userService.findAll()).thenReturn(listUser);
        String forward = command.execute(request, response);
        assertEquals(Path.DISPLAY_ALL_USERS, forward);
    }

    @Test
    void whenCallTheCommandAndThrowServiceException() {
        try {
            when(userService.findAll()).thenThrow(ServiceException.class);
            when(request.getMethod()).thenReturn("GET");
            command.execute(request, response);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
