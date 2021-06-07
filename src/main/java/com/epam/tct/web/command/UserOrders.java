package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserOrders implements Command {
    private static final Logger logger = Logger.getLogger(PostRegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        logger.debug(String.format("forward --> %s", Path.USER_ORDERS));
        logger.debug("Command finished");
        return Path.USER_ORDERS;
    }
}
