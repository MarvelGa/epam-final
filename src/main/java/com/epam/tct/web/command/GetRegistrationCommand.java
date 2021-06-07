package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetRegistrationCommand implements Command {
    private static final Logger logger = Logger.getLogger(GetRegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        logger.debug(String.format("forward --> %s", Path.PAGE__REGISTRATION));
        logger.debug("Command finished");
        return Path.PAGE__REGISTRATION;
    }
}
