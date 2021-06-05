package com.epam.tct.unit.services;

import com.epam.tct.dao.UserDAO;
import com.epam.tct.dao.impl.DaoFactory;
import com.epam.tct.dao.impl.UserDAOImpl;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
import com.epam.tct.service.impl.ServiceFactory;
import com.epam.tct.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    final UserDAO userDAO = mock(UserDAO.class);
    UserService service;
    private User user;
    private List<User> listUser;

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
    void shouldGetUserEmail() {
        String email = "ivanov@gmail.com";
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
}
