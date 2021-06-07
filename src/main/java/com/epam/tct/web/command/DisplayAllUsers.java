package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayAllUsers implements Command {
    private static final Logger logger = Logger.getLogger(DisplayAllUsers.class);
    private UserService userService = ServiceFactory.getInstance().getUserService();

    public DisplayAllUsers() {
    }

    public DisplayAllUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        List<User> users = userService.findAll();
        request.setAttribute("listUsers", users);
        logger.debug(String.format("forward --> %s", Path.DISPLAY_ALL_USERS));
        logger.debug("Command finished");
        return Path.DISPLAY_ALL_USERS;
    }
}
