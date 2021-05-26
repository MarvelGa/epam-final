package com.epam.tct.service.impl;

import com.epam.tct.service.DistanceService;
import com.epam.tct.service.UserService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private final UserService userService = new UserServiceImpl();

    public UserService getUserService() {
        return userService;
    }

    private final DistanceService distanceService = new DistanceServiceImpl();
    public DistanceService getDistanceService(){
        return distanceService;
    }

}
