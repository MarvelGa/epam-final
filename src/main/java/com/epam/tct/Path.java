package com.epam.tct;

public final class Path {
    public static final String ABOUT_US_PAGE = "/WEB-INF/jsp/aboutUs.jsp";

    public static final String PAGE__HOME = "/WEB-INF/jsp/home.jsp";
    public static final String PAGE__LOGIN = "/WEB-INF/jsp/login.jsp";
    public static final String PAGE__REGISTRATION = "/WEB-INF/jsp/register.jsp";
    public static final String USER_CABINET= "/WEB-INF/jsp/userCabinet.jsp";
    public static final String ADMIN_CABINET = "/WEB-INF/jsp/adminCabinet.jsp";
    public static final String CREATE_DELIVERY = "/WEB-INF/jsp/create-delivery.jsp";
    public static final String USER_ORDERS = "/WEB-INF/jsp/user-orders.jsp";
    public static final String USER_All_ORDERS = "/WEB-INF/jsp/all-deliveries.jsp";

    public static final String ALL_USERS_ORDERS = "/WEB-INF/jsp/admin/users-orders.jsp";
    public static final String DISPLAY_ALL_USERS = "/WEB-INF/jsp/admin/all-users.jsp";
    public static final String USER_ORDER_VIEW = "/WEB-INF/jsp/admin/order-view.jsp";
    public static final String ORDERS_VIEW = "/WEB-INF/jsp/admin/all-orders.jsp";
    public static final String COMMAND__ALL_USERS_ORDERS = "controller?command=getAllUsersOrders";
    public static final String CREATE_DELIVERY_BY_ADMIN = "/WEB-INF/jsp/admin/create-delivery.jsp";
    public static final String GET_LIST_OF_USER_ORDERS = "/WEB-INF/jsp/admin/list-orders-of-user.jsp";
    public static final String ERROR_PAGE = "/WEB-INF/errorPage.jsp";

    public static final String COMMAND__USER_ORDER_VIEW = "controller?command=userOrdersPage";
    public static final String COMMAND__USER_CABINET = "controller?command=userCabinet";
    public static final String COMMAND__ADMIN_CABINET = "controller?command=adminCabinet";
    public static final String COMMAND__HOME_PAGE = "controller?command=home";

    public static final String PAGE_ERROR_PAGE = "/WEB-INF/errorPage.jsp";
}
