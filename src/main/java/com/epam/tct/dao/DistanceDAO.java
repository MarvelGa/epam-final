package com.epam.tct.dao;

import com.epam.tct.exception.DaoException;
import com.epam.tct.model.Distance;

import java.util.List;

public interface DistanceDAO {
    List<Distance> readAll() throws DaoException;
}
