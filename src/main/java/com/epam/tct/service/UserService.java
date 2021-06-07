package com.epam.tct.service;

import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.User;

import java.util.List;


public interface UserService {
    User getUserByEmail (String email) throws ServiceException;
    int  addUser(User user) throws ServiceException;
    List<User> findAll() throws ServiceException;
}
