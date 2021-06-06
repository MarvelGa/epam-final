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

public class PostLoginCommandTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);
    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private UserService userService;
    @Mock
    private HttpSession session;

    @InjectMocks
    PostLoginCommand command;
    private User user;
    private List<User> listUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new PostLoginCommand(userService);
        listUser = new ArrayList();
        user = new User();
        user.setId(1);
        user.setEmail("ivanov@gmail.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPassword("202cb962ac59075b964b07152d234b70");
        user.setRoleId(2);
        listUser.add(user);
    }

    @Test
    void whenPassWordIsWrongThanReturnLoginPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn(user.getEmail());
        when(request.getParameter("password")).thenReturn("1");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__LOGIN, forward);
    }

    @Test
    void whenCallPostLoginCommandAndDidAuthorizationAsUserThanReturnUserCabinetPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("password")).thenReturn("123");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
        String forward = command.execute(request, response);
        assertEquals(Path.COMMAND__USER_CABINET, forward);
    }

    @Test
    void whenCallPostLoginCommandAndDidAuthorizationAsAdminThanReturnUserCabinetPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("password")).thenReturn("123");
        user.setRoleId(1);
        when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
        String forward = command.execute(request, response);
        assertEquals(Path.COMMAND__ADMIN_CABINET, forward);
    }

    @Test
    void whenCallPostLoginCommandAndEmailIsNullThanReturnLoginPage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__LOGIN, forward);
    }

}
