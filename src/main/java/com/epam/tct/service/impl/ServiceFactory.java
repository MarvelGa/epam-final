package com.epam.tct.service.impl;

import com.epam.tct.service.UserService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    public static ServiceFactory getInstance() {
        return instance;
    }
    public UserService getUserService() {
        return userService;
    }
}
