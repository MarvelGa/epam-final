package com.epam.tct.service.impl;

import com.epam.tct.dao.DistanceDAO;
import com.epam.tct.dao.UserDAO;
import com.epam.tct.dao.impl.DaoFactory;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.Distance;
import com.epam.tct.service.DistanceService;
import org.apache.log4j.Logger;

import java.util.List;

public class DistanceServiceImpl implements DistanceService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private DistanceDAO distanceDAO = daoFactory.getDistanceDAO();
    private static final Logger logger = Logger.getLogger(DistanceServiceImpl.class);

    @Override
    public List<Distance> findAll() throws ServiceException {
        List<Distance> distanceList;
        try {
            return distanceList = distanceDAO.readAll();
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_READ_ALL_DISTANCES, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_READ_ALL_DISTANCES, e);
        }
    }

    @Override
    public Distance findById(int id) throws ServiceException {
        Distance distance;
        try {
            return distance = distanceDAO.readById(id);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_OBTAIN_DISTANCE_BY_ID, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_OBTAIN_DISTANCE_BY_ID, e);
        }
    }

    @Override
    public int getCityIdByName(String name) throws ServiceException {
        try {
            return distanceDAO.getCityIdByName(name);
        } catch (DaoException e) {
            logger.error(Messages.ERR_SERVICE_LAYER_CANNOT_GET_CITY_ID, e);
            throw new ServiceException(Messages.ERR_SERVICE_LAYER_CANNOT_GET_CITY_ID, e);
        }
    }
}
