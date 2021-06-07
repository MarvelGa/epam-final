package com.epam.tct.exception;

public final class Messages {

    private Messages() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
    public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
    public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";
    public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
    public static final String ERR_CANNOT_CLOSE_PREPARED_STATEMENT = "Cannot close a prepared statement";
    public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";
    public static final String CANNOT_ROLLBACK_TRANSACTION = "Cannot rollback transaction";

    public static final String ERR_CANNOT_INSERT_USER = "Cannot insert new user";
    public static final String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";
    public static final String ERR_CANNOT_OBTAIN_USER_BY_EMAIL = "Cannot obtain a user by its email";
    public static final String ERR_CANNOT_UPDATE_USER = "Cannot update a user";
    public static final String ERR_CANNOT_DELETE_USER = "Cannot delete new user";
    public static final String ERR_CANNOT_READ_ALL_USERS = "Cannot read all users";
    public static final String ERR_CANNOT_COUNT_ALL_USERS = "Cannot count all users";

    public static final String ERR_SERVICE_LAYER_CANNOT_OBTAIN_USER_BY_EMAIL = "Cannot obtain a user by its email at service layer";
    public static final String ERR_SERVICE_LAYER_CANNOT_INSERT_USER = "Cannot insert new user at service layer";
    public static final String ERR_SERVICE_LAYER_CANNOT_READ_ALL_USERS = "Cannot read all users at service layer";

    public static final String ERR_CANNOT_OBTAIN_DISTANCE_BY_ID = "Cannot obtain a distance by its id";
    public static final String ERR_CANNOT_READ_ALL_DISTANCES = "Cannot read all distances";

    public static final String ERR_SERVICE_LAYER_CANNOT_OBTAIN_DISTANCE_BY_ID = "Cannot obtain a distance by its id at service layer";
    public static final String ERR_SERVICE_LAYER_CANNOT_READ_ALL_DISTANCES = "Cannot read all distances at service layer";

    public static final String ERR_SERVICE_LAYER_CANNOT_CREATE_ORDER = "Cannot create the order at service layer";
    public static final String ERR_CANNOT_INSERT_ORDER = "Cannot insert new order";
    public static final String ERR_CANNOT_UPDATE_ORDER_STATUS_BY_ORDER_ID = "Cannot update order status by order id";
    public static final String ERR_CANNOT_GET_USER_ORDER_BY_ORDER_ID = "Cannot get user order by order id";
    public static final String ERR_CANNOT_GET_ALL_ORDERS_BY_USER_ID = "Cannot get all orders by userId";
    public static final String ERR_CANNOT_GET_ALL_USERS_ORDERS = "Cannot get all users' orders";
    public static final String ERR_CANNOT_GET_ORDERS = "Cannot get orders";
    public static final String ERR_CANNOT_GET_CITY_ID = "Cannot get id of the city";
    public static final String ERR_SERVICE_LAYER_CANNOT_GET_CITY_ID = "Cannot get id of the city";
    public static final String ERR_SERVICE_LAYER_CANNOT_GET_ALL_ORDERS_BY_USER_ID = "Cannot get all orders by userId";
    public static final String ERR_SERVICE_LAYER_CANNOT_GET_ALL_USERS_ORDER = "Cannot get all users' orders";
    public static final String ERR_SERVICE_LAYER_CANNOT_GET_ORDERS = "Cannot get orders";
    public static final String ERR_SERVICE_LAYER_CANNOT_UPDATE_ORDER_STATUS_BY_ORDER_ID = "Cannot update order status by order id";
    public static final String ERR_SERVICE_LAYER_CANNOT_GET_USER_ORDER_BY_ORDER_ID = "Cannot get user order by order id";
}
