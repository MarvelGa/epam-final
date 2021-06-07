package com.epam.tct.dao;

import com.epam.tct.exception.DaoException;
import com.epam.tct.model.User;

import java.util.List;

public interface UserDAO {

    User getUserByEmail(String email) throws DaoException;

    int createUser(User user) throws DaoException;

    List<User> readAllUsers() throws DaoException;

}
