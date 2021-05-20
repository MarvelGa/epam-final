//package com.epam.tct.web;
//
//import com.epam.tct.exception.AppException;
//import com.epam.tct.web.command.Command;
//import com.epam.tct.web.command.CommandContainer;
//import org.apache.log4j.Logger;
//import com.epam.tct.Path;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//public class Controller extends HttpServlet {
//    private static final Logger LOG = Logger.getLogger(Controller.class);
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        LOG.debug("Controller starts");
//
//        // extract command name from the request
//        String commandName = request.getParameter("command");
//        LOG.trace("Request parameter: command --> " + commandName);
//
//        // obtain command object by its name
//        Command command = CommandContainer.get(commandName);
//        LOG.trace("Obtained command --> " + command);
//
//        // execute command and get forward address
//        String forward = Path.PAGE__LOGIN;
//        try {
//            forward = command.execute(request, response);
//        } catch (AppException ex) {
//            request.setAttribute("errorMessage", ex.getMessage());
//        }
//        LOG.trace("Forward address --> " + forward);
//
//        LOG.debug("Controller finished, now go to forward address --> " + forward);
//
//        if (forward.contains("controller?command")) {
//            response.sendRedirect(forward);
//        } else if (forward.contains("ajax")) {
//            String result = (String) request.getAttribute("result");
//            response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
//            response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
//            System.out.println(result);
//            response.getWriter().write(result);
//
//        } else {
//            request.getRequestDispatcher(forward).forward(request, response);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//}
