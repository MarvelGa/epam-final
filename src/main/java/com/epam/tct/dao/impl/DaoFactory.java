package com.epam.tct.dao.impl;

import com.epam.tct.dao.UserDAO;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDAO userDao = new UserDAOImpl();

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDao() {
        return userDao;
    }
}
