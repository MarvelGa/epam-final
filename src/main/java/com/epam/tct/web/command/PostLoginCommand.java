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

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
//        String login = request.getParameter("login");
//        String password  = request.getParameter("pass");

//        User users = new User();
//        ErrorObj eo = new ErrorObj();
//        DBWorker worker = new DBWorker();
//
//        if (login != null) {
//            if (login.isEmpty() || password.isEmpty()) {
//                eo.setErrorAuthorization();
//                users.setLogin(login);
//                model.addAttribute("users", users);
//                model.addAttribute("errorObj", eo);
//            } else {
//                if(worker.getConnection()!=null ) {
//                    if (new FormChecker().check(login, password)) {
//                        users.setLogin(login);
//                        users.setName(login);
//                        session.setAttribute("users", users);
//                        eo.setAccess();
//                        model.addAttribute("errorObj", eo);
//                        return "../../index";
//                    }
//                    else {
//                        count++;
//                        session.setAttribute("count", count);
//                    }
//                }else {
//                    return "connectionToDBError";
//                }
//                if( eo.isConSQLError()){
//                    return "connectionToDBError";
//                }
//            }
//        }
//        return "formLogin";


        log.debug("Command starts");
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        log.trace("Request parameter: loging --> " + email);
        String password = request.getParameter("password");

        // error handler
        String errorMessage = null;
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
                session.setAttribute("user", user);
                log.trace("Set the session attribute: user --> " + user);
                forward = Path.ADMIN_CABINET;
            }

            if (userRole == Role.USER){
                session.setAttribute("userRole", userRole);
                log.trace("Set the session attribute: userRole --> " + userRole);
                forward = Path.USER_CABINET;
            }

            log.info("User " + user + " logged as " + userRole.toString().toLowerCase());

            // work with i18n
//            String userLocaleName = user.getLocaleName();
//            log.trace("userLocalName --> " + userLocaleName);
//
//            if (userLocaleName != null && !userLocaleName.isEmpty()) {
//                Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", userLocaleName);
//
//                session.setAttribute("defaultLocale", userLocaleName);
//                log.trace("Set the session attribute: defaultLocaleName --> " + userLocaleName);
//
//                log.info("Locale for user: defaultLocale --> " + userLocaleName);
//            }
          //  return
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
