package com.epam.tct.unittest.services;

import com.epam.tct.dao.UserDAO;
import com.epam.tct.exception.DaoException;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
import com.epam.tct.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    final UserDAO userDAO = mock(UserDAO.class);
    UserService service;
    private User user;
    private List<User> listUser;
    private String email = "ivanov@gmail.com";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new UserServiceImpl(userDAO);
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
    void shouldAddUser() {
        try {
            when(userDAO.createUser(user)).thenReturn(1);
            int expected = 1;
            int actual = service.addUser(user);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryAddUserThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(userDAO).createUser(user);
            service.addUser(user);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetUserEmail() {
        try {
            when(userDAO.getUserByEmail(email)).thenReturn(user);
            User expected = user;
            User actual = service.getUserByEmail(email);
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryGetUserEmailThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(userDAO).getUserByEmail(email);
            service.getUserByEmail(email);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void shouldGetAllUsersFromDB() {
        try {
            when(userDAO.readAllUsers()).thenReturn(listUser);
            List<User> expected = listUser;
            List<User> actual = service.findAll();
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void whenTryGetAllUsersFromDBThanThrowsDaoException() {
        try {
            doThrow(DaoException.class).when(userDAO).readAllUsers();
            service.findAll();
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
