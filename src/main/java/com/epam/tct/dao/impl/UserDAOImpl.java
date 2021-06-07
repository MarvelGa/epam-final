package com.epam.tct.dao.impl;

import com.epam.tct.dao.UserDAO;
import com.epam.tct.dao.dbmanager.DBManager;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";
    private static final String CREAT_USER = "INSERT INTO users (email, first_name, last_name, password, role_id) VALUES (?, ?, ?, ?, ?);";
    private static final String GET_ALL_USERS = "SELECT u.id, u.email, u.first_name, u.last_name, r.name FROM users u, roles r WHERE r.id=u.role_id;";

    @Override
    public User getUserByEmail(String email) throws DaoException {
        User user = null;
        DBManager dbm;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(GET_USER_BY_EMAIL);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_OBTAIN_USER_BY_ID, ex);
            throw new DaoException(Messages.ERR_CANNOT_OBTAIN_USER_BY_EMAIL, ex);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return user;
    }


    @Override
    public int createUser(User user) throws DaoException {
        int id = -1;
        final String query = CREAT_USER;
        DBManager dbm;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, 2);

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_INSERT_USER, ex);
            throw new DaoException(Messages.ERR_CANNOT_INSERT_USER, ex);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return id;
    }

    @Override
    public List<User> readAllUsers() throws DaoException {
        final String query = GET_ALL_USERS;
        List<User> userList = new ArrayList<>();
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
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setFirstName(rs.getString(3));
                user.setLastName(rs.getString(4));
                user.setRoleName(rs.getString(5).toUpperCase());
                userList.add(user);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_READ_ALL_USERS, ex);
            throw new DaoException(Messages.ERR_CANNOT_READ_ALL_USERS, ex);
        } finally {
            DBManager.close(con, stmt, rs);
        }
        return userList;
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setEmail(rs.getString(2));
        user.setFirstName(rs.getString(3));
        user.setLastName(rs.getString(4));
        user.setPassword(rs.getString(5));
        user.setRoleId(rs.getInt(6));
        return user;
    }
}
