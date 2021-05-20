package com.epam.tct.web;

import com.epam.tct.exception.AppException;
import com.epam.tct.web.command.Command;
import com.epam.tct.web.command.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process (req, resp);
        } catch (AppException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process (req, resp);
        } catch (AppException e) {
            e.printStackTrace();
        }
    }

    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, AppException {
        String address = "error.jsp";
        String commandName =req.getParameter("command");
        Command command = CommandContainer.getCommand(commandName);
        try{
            address =command.execute(req, resp);

        }catch (AppException ex){
            req.setAttribute("errorMessage", ex.getMessage());
        }
        req.getRequestDispatcher(address).forward(req,resp);
    }
}
