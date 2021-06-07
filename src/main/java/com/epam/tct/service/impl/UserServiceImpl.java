package com.epam.tct.service.impl;

import com.epam.tct.dao.UserDAO;
import com.epam.tct.dao.impl.DaoFactory;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private UserDAO userDAO = daoFactory.getUserDao();
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserByEmail(String email) throws ServiceException {
        User user;
        try {
            user = userDAO.getUserByEmail(email);
            return user;
        } catch (DaoException ex) {
            logger.error(ex);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_OBTAIN_USER_BY_EMAIL, ex);
        }
    }

    @Override
    public int addUser(User user) throws ServiceException {
        int inserted;
        try {
            inserted = userDAO.createUser(user);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_INSERT_USER, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_INSERT_USER, e);
        }
        return inserted;
    }


    @Override
    public List<User> findAll() throws ServiceException {
        List<User> userList;
        try {
            return userList = userDAO.readAllUsers();
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_READ_ALL_USERS, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_READ_ALL_USERS, e);
        }
    }

}
