package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

public class AuthorizationPage implements Command {
    private static final Logger log = Logger.getLogger(AuthorizationPage.class);

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
        String login = request.getParameter("login");
        log.trace("Request parameter: loging --> " + login);
        String password = request.getParameter("password");

        // error handler
        String errorMessage = null;
        String forward = Path.ERROR_PAGE;

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            errorMessage = "Login/password cannot be empty";
            request.setAttribute("errorMessage", errorMessage);
            log.error("errorMessage --> " + errorMessage);
            return Path.PAGE__LOGIN;
        }

//        User user = new UserDao().findUserByLogin(login);
//        log.trace("Found in DB: user --> " + user);
//
//        if (user == null || !password.equals(user.getPassword())) {
//            errorMessage = "Cannot find user with such login/password";
//            request.setAttribute("errorMessage", errorMessage);
//            log.error("errorMessage --> " + errorMessage);
//            return forward;
//        } else {
//            Role userRole = Role.getRole(user);
//            log.trace("userRole --> " + userRole);
//
//            if (userRole == Role.ADMIN)
//                forward = Path.COMMAND__LIST_ORDERS;
//
//            if (userRole == Role.CLIENT)
//                forward = Path.COMMAND__LIST_MENU;
//
//            session.setAttribute("user", user);
//            log.trace("Set the session attribute: user --> " + user);
//
//            session.setAttribute("userRole", userRole);
//            log.trace("Set the session attribute: userRole --> " + userRole);
//
//            log.info("User " + user + " logged as " + userRole.toString().toLowerCase());
//
//            // work with i18n
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
//        }

        log.debug("Command finished");
        return forward;
    }
}
