package com.epam.tct.dao.impl;

import com.epam.tct.dao.DistanceDAO;
import com.epam.tct.dao.UserDAO;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    public static DaoFactory getInstance() {
        return instance;
    }

    private final UserDAO userDao = new UserDAOImpl();

    public UserDAO getUserDao() {
        return userDao;
    }

    private final DistanceDAO distanceDAO = new DistanceDAOImpl();

    public DistanceDAO getDistanceDAO() {
        return distanceDAO;
    }


}
