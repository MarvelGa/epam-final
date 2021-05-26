package com.epam.tct.service;

import com.epam.tct.exception.ServiceException;
import com.epam.tct.model.Distance;

import java.util.List;

public interface DistanceService {
    List<Distance> findAll() throws ServiceException;
}
