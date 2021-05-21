package com.epam.tct.service;

import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.User;

import java.util.List;


public interface UserService {
    User getUserByEmail (String email) throws ServiceException;
    int  addUser(User user) throws ServiceException;
    User getUser(int id) throws ServiceException;
    boolean saveUser(User user) throws ServiceException;
    boolean removeUserById(int id) throws ServiceException;
    List<User> findAll() throws ServiceException;
    int countAllUsers() throws ServiceException;
}
