package com.epam.tct.exception;

public final class Messages {

        private Messages() throws IllegalAccessException {
            throw new IllegalAccessException();
        }

        // DB exceptions
        public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
        public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
        public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";
        public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
        public static final String ERR_CANNOT_CLOSE_PREPARED_STATEMENT = "Cannot close a prepared statement";
        public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";
        public static final String CANNOT_ROLLBACK_TRANSACTION = "Cannot rollback transaction";


        //user entity exceptions
        public static final String ERR_CANNOT_INSERT_USER = "Cannot insert new user";
        public static final String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";
        public static final String ERR_CANNOT_OBTAIN_USER_BY_EMAIL = "Cannot obtain a user by its email";
        public static final String ERR_CANNOT_UPDATE_USER = "Cannot update a user";
        public static final String ERR_CANNOT_DELETE_USER = "Cannot delete new user";
        public static final String ERR_CANNOT_READ_ALL_USERS = "Cannot read all users";
        public static final String ERR_CANNOT_COUNT_ALL_USERS = "Cannot count all users";
        public static final String ERR_CANNOT_READ_USERS_WITH_LIMITATION = "Cannot read users with limitation";
        // city entity exceptions
        public static final String ERR_CANNOT_INSERT_CITY = "Cannot insert new city";
        public static final String ERR_CANNOT_OBTAIN_CITY_BY_ID = "Cannot obtain a city by its id";
        public static final String ERR_CANNOT_OBTAIN_CITY_BY_NAME = "Cannot obtain a city by its name";
        public static final String ERR_CANNOT_UPDATE_CITY = "Cannot update a city";
        public static final String ERR_CANNOT_DELETE_CITY = "Cannot delete new city";
        public static final String ERR_CANNOT_READ_ALL_CITIES = "Cannot read all cities";
        public static final String ERR_CANNOT_COUNT_ALL_CITIES = "Cannot count all cities";
        public static final String ERR_CANNOT_READ_CITIES_WITH_LIMITATION = "Cannot read cities with limitation";
        // request entity exceptions
        public static final String ERR_CANNOT_INSERT_REQUEST = "Cannot insert new request";
        public static final String ERR_CANNOT_OBTAIN_REQUEST_BY_ID = "Cannot obtain a request by its id";
        public static final String ERR_CANNOT_OBTAIN_REQUEST_BY_NAME = "Cannot obtain a request by its name";
        public static final String ERR_CANNOT_UPDATE_REQUEST = "Cannot update a request";
        public static final String ERR_CANNOT_DELETE_REQUEST = "Cannot delete new request";
        public static final String ERR_CANNOT_READ_ALL_REQUESTS = "Cannot read all requests";
        public static final String ERR_CANNOT_COUNT_ALL_REQUESTS = "Cannot count all requests";
        public static final String ERR_CANNOT_COUNT_REQUESTS_WITH_CONDITION = "Cannot count requests with condition";
        public static final String ERR_CANNOT_READ_REQUESTS_WITH_LIMITATION = "Cannot read requests with limitation";

        public static final String ERR_SERVICE_LAYER_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_OBTAIN_USER_BY_EMAIL = "Cannot obtain a user by its email at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_INSERT_USER = "Cannot insert new user at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_UPDATE_USER = "Cannot update a user at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_DELETE_USER = "Cannot delete new user at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_READ_ALL_USERS = "Cannot read all users at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_READ_USERS_WITH_LIMITATION = "Cannot read users with limitation at service layer";

        // distance entity exceptions
        public static final String ERR_CANNOT_INSERT_DISTANCE = "Cannot insert new distance";
        public static final String ERR_CANNOT_OBTAIN_DISTANCE_BY_ID = "Cannot obtain a distance by its id";
        public static final String ERR_CANNOT_OBTAIN_DISTANCE_BY_NAME = "Cannot obtain a distance by its name";
        public static final String ERR_CANNOT_OBTAIN_DISTANCE_BY_ITS_FIELDS = "Cannot obtain a distance by its fields(fromCityId, toCityId)";
        public static final String ERR_CANNOT_UPDATE_DISTANCE = "Cannot update a distance";
        public static final String ERR_CANNOT_DELETE_DISTANCE = "Cannot delete new distance";
        public static final String ERR_CANNOT_READ_ALL_DISTANCES = "Cannot read all distances";
        public static final String ERR_CANNOT_COUNT_ALL_DISTANCES = "Cannot count all distances";
        public static final String ERR_CANNOT_READ_DISTANCES_WITH_LIMITATION = "Cannot read distances with limitation";

        public static final String ERR_SERVICE_LAYER_CANNOT_OBTAIN_DISTANCE_BY_ID = "Cannot obtain a distance by its id at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_INSERT_DISTANCE = "Cannot insert new distance at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_UPDATE_DISTANCE = "Cannot update a distance at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_DELETE_DISTANCE = "Cannot delete new distance at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_READ_ALL_DISTANCES = "Cannot read all distances at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_READ_DISTANCES_WITH_LIMITATION = "Cannot read distances with limitation at service layer";
        public static final String ERR_SERVICE_LAYER_CANNOT_OBTAIN_DISTANCE_BY_ITS_FIELDS = "Cannot obtain a distance by its fields(fromCityId, toCityId) at service layer";

        public static final String ERR_CANNOT_INSERT_ORDER = "Cannot insert new order";

}
