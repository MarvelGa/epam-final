package com.epam.tct.filter;

import com.epam.tct.Path;
import com.epam.tct.model.Role;
import com.epam.tct.model.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class CommandAccessFilter implements Filter {

    private static final Logger logger = Logger.getLogger(CommandAccessFilter.class);

    private final Map<Role, List<String>> accessMap = new HashMap<Role, List<String>>();

    private List<String> commons = new ArrayList<String>();

    private List<String> outOfControl = new ArrayList<String>();

    @Override
    public final void destroy() {
        logger.debug("Filter destruction starts");

        logger.debug("Filter destruction finished");
    }

    @Override
    public final void doFilter(final ServletRequest request,
                               final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        logger.debug("Filter starts");
        if (accessAllowed(request)) {
            logger.debug("Filter finished");
            chain.doFilter(request, response);
        } else {
            String errorMessasge = "You do not have permission "
                    + "to access the requested resource";

            request.setAttribute("errorMessage", errorMessasge);
            logger.trace("Set the request attribute: errorMessage --> "
                    + errorMessasge);

            request.getRequestDispatcher(
                    Path.PAGE_ERROR_PAGE).forward(request, response);
        }
    }


    private boolean accessAllowed(final ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getRequestURI().equalsIgnoreCase("/tct/changeLocale")) {
            logger.trace("Accessed allowed for changing language");
            return true;
        }
        String commandName = request.getParameter("command");
        if (commandName == null || commandName.isEmpty()) {
            return false;
        }

        if (outOfControl.contains(commandName)) {
            return true;
        }

        HttpSession session = httpRequest.getSession(false);
        if (session == null) {
            return false;
        }

        User user = (User) session.getAttribute("user");
        if (Objects.isNull(user)) {
            return false;
        }
        Role roleName = Role.getRole(user);

        return accessMap.get(roleName).contains(commandName)
                || commons.contains(commandName);
    }

    @Override
    public final void init(final FilterConfig fConfig)
            throws ServletException {
        logger.debug("Filter initialization starts");

        // roles
        accessMap.put(Role.ADMIN, asList(fConfig.getInitParameter("restrictedAdmin")));
        accessMap.put(Role.USER, asList(fConfig.getInitParameter("restrictedUser")));
        logger.trace("Access map  --> " + accessMap);

        // commons
        commons = asList(fConfig.getInitParameter("common"));
        logger.trace("Common commands --> " + commons);

        // out of control
        outOfControl = asList(fConfig.getInitParameter("out-of-control"));
        logger.trace("Out of control commands --> " + outOfControl);

        logger.debug("Filter initialization finished");
    }

    private List<String> asList(final String str) {
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        return list;
    }

}