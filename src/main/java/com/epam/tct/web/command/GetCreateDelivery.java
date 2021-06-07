package com.epam.tct.web.command;

import com.epam.tct.Path;
import com.epam.tct.exception.AppException;
import com.epam.tct.model.Distance;
import com.epam.tct.service.DistanceService;
import com.epam.tct.service.impl.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCreateDelivery implements Command {
    private static final Logger logger = Logger.getLogger(GetCreateDelivery.class);
    private DistanceService distanceService = ServiceFactory.getInstance().getDistanceService();

    public GetCreateDelivery() {
    }

    public GetCreateDelivery(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        logger.debug("Command starts");
        int id = Integer.valueOf(request.getParameter("id"));
        Distance data = distanceService.findById(id);
        request.setAttribute("distance", data);
        logger.debug(String.format("forward --> %s", Path.CREATE_DELIVERY));
        logger.debug("Command finished");
        return Path.CREATE_DELIVERY;
    }
}
