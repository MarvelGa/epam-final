package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostRegistrationCommandTest {
    final HttpServletRequest request = mock(HttpServletRequest.class);
    final HttpServletResponse response = mock(HttpServletResponse.class);

    @Mock
    private UserService userService;
    @Mock
    private HttpSession session;

    @InjectMocks
    PostRegistrationCommand command;

    String notValidPassword ="11";
    String notValidEmail ="@gmail.com";
    String notValidName ="bs";
    String notValidLastName ="a";
    private User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        command = new PostRegistrationCommand(userService);

        user = new User();
        user.setId(1);
        user.setEmail("ivanov@gmail.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPassword("202cb962ac59075b964b07152d234b70");
        user.setRoleId(2);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputDataIsValidThanReturnWelcomeHomePage() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn("TESTtest222");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.COMMAND__HOME_PAGE, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputPassWordIsNotValidThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn(notValidPassword);
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputEmailIsNotValidThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn(notValidEmail);
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputNameIsNotValidThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn(notValidName);
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputLastNameIsNotValidThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn(notValidLastName);
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputEmailIsNullThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputLastNameIsNullThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn(null);
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputNameIsNullThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn(null);
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndInputPassWordIsNullThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn(null);
        when(userService.getUserByEmail(user.getEmail())).thenReturn(null);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }

    @Test
    void whenCallPostRegistrationCommandAndUserIsAlreadyExistThanReturnRegistrationPageAgain() throws ServletException, IOException, AppException {
        when(request.getMethod()).thenReturn("POST");
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("ivanov@gmail.com");
        when(request.getParameter("name")).thenReturn("Ivan");
        when(request.getParameter("lastName")).thenReturn("Ivanov");
        when(request.getParameter("password")).thenReturn("TESTtest22");
        when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
        String forward = command.execute(request, response);
        assertEquals(Path.PAGE__REGISTRATION, forward);
    }
}
