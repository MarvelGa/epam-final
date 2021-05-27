package com.epam.tct;

public final class Path {
    public static final String PAGE__HOME = "/WEB-INF/jsp/home.jsp";
    public static final String PAGE__LOGIN = "/WEB-INF/jsp/login.jsp";
    public static final String PAGE__REGISTRATION = "/WEB-INF/jsp/register.jsp";
    public static final String USER_CABINET= "/WEB-INF/jsp/userCabinet.jsp";
    public static final String ADMIN_CABINET = "/WEB-INF/jsp/adminCabinet.jsp";
    public static final String CREATE_DELIVERY = "/WEB-INF/jsp/create-delivery.jsp";
//    public static final String PAGE__LOGIN = "/login.jsp";
    public static final String PAGE__LIST_ORDERS = "/WEB-INF/jsp/admin/list_items.jsp";
    public static final String MAIN_PAGE = "/WEB-INF/jsp/admin/list_items.jsp";
    public static final String ERROR_PAGE = "/WEB-INF/errorPage.jsp";

    // commands
    public static final String COMMAND__LIST_ORDERS = "/controller?command=listMenu";
    public static final String COMMAND__LIST_MENU = "/controller?command=getOrder";
}
