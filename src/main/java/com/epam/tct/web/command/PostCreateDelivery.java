package com.epam.tct.web.command;

import com.epam.tct.exception.AppException;
import com.epam.tct.model.Distance;
import com.epam.tct.model.User;
import com.epam.tct.service.DistanceService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PostCreateDelivery implements Command{
    private static final Logger log = Logger.getLogger(PostCreateDelivery.class);
    private DistanceService distanceService = ServiceFactory.getInstance().getDistanceService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        int id = Integer.valueOf(request.getParameter("id"));
        HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
         Distance data = distanceService.findById(id);

        return null;
    }
}
