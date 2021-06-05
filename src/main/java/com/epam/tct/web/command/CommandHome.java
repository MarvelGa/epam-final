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
import java.util.List;

public class CommandHome implements Command{
    private static final Logger log = Logger.getLogger(CommandHome.class);
    private DistanceService distanceService = ServiceFactory.getInstance().getDistanceService();

    public CommandHome() {
    }

    public CommandHome(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
      List<Distance> data = distanceService.findAll();
      request.setAttribute("data", data);
        return Path.PAGE__HOME;
    }
}
