package com.epam.tct.dao.impl;

import com.epam.tct.dao.DistanceDAO;
import com.epam.tct.dao.dbmanager.DBManager;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.model.City;
import com.epam.tct.model.Distance;
import com.epam.tct.model.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistanceDAOImpl implements DistanceDAO {
    private static final Logger logger = Logger.getLogger(DistanceDAOImpl.class);
    private static final String GET_CITIES_AND_DISTANCE = " SELECT d.id, c1.`name`, c2.`name`, d.distance FROM distance d, cities c1,  cities c2 WHERE c1.id = d.city_from_id AND c2.id = d.city_to_id;";
    private static final String GET_DATA_FROM_DISTANCE_TABLE_BY_ID = "SELECT d.id, c1.`name`, c2.`name`, d.distance FROM distance d, cities c1,  cities c2 WHERE d.id = ? AND c1.id = d.city_from_id AND c2.id = d.city_to_id ;";
    private static final String GET_CITY_ID_BY_NAME = "SELECT c.id FROM cities c WHERE c.name=?";

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
                distanceList.add(extractDistanceFromResultSet(rs));
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

    @Override
    public Distance readById(int id) throws DaoException {
        final String query = GET_DATA_FROM_DISTANCE_TABLE_BY_ID;
        Distance distance = null;
        DBManager dbm;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                distance = extractDistanceFromResultSet(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_OBTAIN_DISTANCE_BY_ID, ex);
            throw new DaoException(Messages.ERR_CANNOT_OBTAIN_DISTANCE_BY_ID, ex);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return distance;
    }

    @Override
    public int getCityIdByName(String name) throws DaoException {
        final String query = GET_CITY_ID_BY_NAME;
        int id =-1;
        DBManager dbm;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                id= rs.getInt(1);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_GET_CITY_ID, ex);
            throw new DaoException(Messages.ERR_CANNOT_GET_CITY_ID, ex);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return id;
    }

    private Distance  extractDistanceFromResultSet(ResultSet rs) throws SQLException {
        Distance data = new Distance();
        data.setId(rs.getInt(1));
        data.setCityFrom(rs.getString(2));
        data.setCityTo(rs.getString(3));
        data.setDistance(rs.getDouble(4));
        return data;
    }
}
