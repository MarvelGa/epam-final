package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Role;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class PostLoginCommand implements Command {

    private static final Logger log = Logger.getLogger(PostLoginCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserService();

    public PostLoginCommand() {
    }

    public PostLoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {

        log.debug("Command starts");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        log.trace("Request parameter: loging --> " + email);
        String password = request.getParameter("password");

        String errorMessage;
        String forward = Path.ERROR_PAGE;

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            errorMessage = "Login/password cannot be empty";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return Path.PAGE__LOGIN;
        }

        User user = userService.getUserByEmail(email);
        log.trace("Found in DB: user --> " + user);

        if (user == null || !user.getPassword().equals(encryptPassword(password))) {
            errorMessage = "Wrong login or password";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return Path.PAGE__LOGIN;
        } else {
            Role userRole = Role.getRole(user);
            log.trace("userRole --> " + userRole);
            session.setAttribute("user", user);
            if (userRole == Role.ADMIN){
                session.setAttribute("userRole", userRole);
                log.trace("Set the session attribute: user --> " + user);
                forward = Path.COMMAND__ADMIN_CABINET;
            }

            if (userRole == Role.USER){
                session.setAttribute("userRole", userRole);
                log.trace("Set the session attribute: userRole --> " + userRole);
                forward = Path.COMMAND__USER_CABINET;
            }

            log.info("User " + user + " logged as " + userRole.toString().toLowerCase());

        }

        log.debug("Command finished");
        return forward;
    }


    private String encryptPassword(final String password) throws AppException {
        if (Objects.isNull(password) || password.isEmpty()) {
            return null;
        }
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
            throw new AppException(e.getMessage(), e);
        }
    }

}
