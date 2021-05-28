package com.epam.tct.dao;

import com.epam.tct.exception.DaoException;
import com.epam.tct.model.City;
import com.epam.tct.model.Distance;

import java.util.List;

public interface DistanceDAO {
    List<Distance> readAll() throws DaoException;
    Distance readById(int id) throws DaoException;
    int getCityIdByName(String name) throws DaoException;
}
