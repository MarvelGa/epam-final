package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.User;
import com.epam.tct.service.UserService;
import com.epam.tct.service.impl.ServiceFactory;
import com.epam.tct.web.validator.DataValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class PostRegistrationCommand implements Command {
    private static final Logger logger = Logger.getLogger(PostRegistrationCommand.class);
    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        List<String> errorList = new ArrayList<>();
        if (email == null || name == null || lastName == null || password == null || email.isEmpty() || name.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            String errorMessage = "Each field must be filled";
            request.setAttribute("errorMessage", errorMessage);
            logger.error("errorMessage --> " + errorMessage);
            return Path.PAGE__REGISTRATION;
        }
        if (userService.getUserByEmail(email) != null) {
            logger.trace("User with this email already exist");
            String errorMessage = "User with this email already exist";
            errorList.add(errorMessage);
        }
        if (!DataValidator.isEmailValid(email)) {
            logger.trace("Invalid email");
            String errorMessage = "You entered invalid email";
            errorList.add(errorMessage);
        }

        if (!DataValidator.isNameValid(name)) {
            logger.trace("Invalid name");
            String errorMessage = "You entered invalid name";
            errorList.add(errorMessage);
        }
        if (!DataValidator.isSurnameValid(lastName)) {
            logger.trace("Invalid surname");
            String errorMessage = "You entered invalid lastName";
            errorList.add(errorMessage);
        }
        if (!DataValidator.isPasswordValid(password)) {
            logger.trace("Invalid password");
            String errorMessage = "You entered invalid password";
            errorList.add(errorMessage);
        }

        if (!errorList.isEmpty()) {
            request.setAttribute("errorMessages", errorList);
            return Path.PAGE__REGISTRATION;
        } else {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setFirstName(name);
            newUser.setLastName(lastName);
            newUser.setPassword(encryptPassword(password));
            newUser.setRoleId(2);
            logger.trace("Saving new user: " + newUser);
            userService.addUser(newUser);
            session.setAttribute("user", newUser);
            return Path.COMMAND__HOME_PAGE;
        }

    }

    private String encryptPassword(final String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
            return password.hashCode() + password.hashCode() + "";
        }
    }
}
