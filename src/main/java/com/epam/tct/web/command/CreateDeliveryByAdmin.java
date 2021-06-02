package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Distance;
import com.epam.tct.model.OrderItem;
import com.epam.tct.service.DistanceService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CreateDeliveryByAdmin implements Command {
    private static final Logger log = Logger.getLogger(CreateDeliveryByAdmin.class);
    private DistanceService distanceService = ServiceFactory.getInstance().getDistanceService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        List<Distance> data = distanceService.findAll();
        HttpSession session = request.getSession();
        if (session != null) {
            session.setAttribute("cityAndDistance", data);
        }
        return Path.CREATE_DELIVERY_BY_ADMIN;

    }
}
