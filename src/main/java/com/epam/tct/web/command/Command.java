package com.epam.tct.web.command;

import com.epam.tct.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public interface Command extends Serializable {
    String execute(HttpServletRequest request,
                   HttpServletResponse response)
            throws IOException, ServletException, AppException;
}
