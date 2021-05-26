package com.epam.tct.dao.impl;

import com.epam.tct.dao.DistanceDAO;
import com.epam.tct.dao.dbmanager.DBManager;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.model.Distance;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DistanceDAOImpl implements DistanceDAO {
    private static final Logger logger = Logger.getLogger(DistanceDAOImpl.class);
    private static final String GET_CITIES_AND_DISTANCE = " SELECT c1.`name`, c2.`name`, d.distance FROM distance d, cities c1,  cities c2 WHERE c1.id = d.city_from AND c2.id = d.city_to;";

    @Override
    public List<Distance> readAll() throws DaoException {
        final String query = GET_CITIES_AND_DISTANCE;
        List<Distance> distanceList = new ArrayList<>();
        DBManager dbm;
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Distance data  = new Distance();
                data.setCityFrom(rs.getString(1));
                data.setCityTo(rs.getString(2));
                data.setDistance(rs.getDouble(3));
                distanceList.add(data);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_READ_ALL_DISTANCES, ex);
            throw new DaoException(Messages.ERR_CANNOT_READ_ALL_DISTANCES, ex);
        } finally {
            DBManager.close(con, stmt, rs);
        }
        return distanceList;
    }


}
