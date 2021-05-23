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
    private static final String DELETE_USER_BY_ID = "DELETE FROM users where id = ?;";
    private static final String GET_ALL_USERS = "SELECT * FROM users;";
    private static final String GET_COUNT_OF_USERS = "select count(*) from users;";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String UPDATE_USER_BY_ID = "UPDATE users SET email = ?, first _name = ?, last_name = ?, password=?, role_id = ?,  WHERE id = ?;";

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
        if (user.getId() != 0 && user.getId() > 0) {
            return 0;
        }
        final String query = CREAT_USER;
        DBManager dbm;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            int k = 1;
            pstmt.setString(k++, user.getEmail());
            pstmt.setString(k++, user.getFirstName());
            pstmt.setString(k++, user.getLastName());
            pstmt.setString(k++, user.getPassword());
            pstmt.setInt(k, 2);

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
    public int countAllUsers() throws DaoException {
        final String query = GET_COUNT_OF_USERS;
        DBManager dbm;
        Connection con = null;
        Statement smt = null;
        ResultSet rs = null;
        int usersNumber = 0;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            smt = con.createStatement();
            rs = smt.executeQuery(query);
            rs.next();
            usersNumber = rs.getInt(1);
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_COUNT_ALL_USERS);
            throw new DaoException(Messages.ERR_CANNOT_COUNT_ALL_USERS, ex);
        } finally {
            DBManager.close(con, smt, rs);
        }
        return usersNumber;
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
                userList.add(extractUserFromResultSet(rs));
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

    @Override
    public boolean deleteUserById(int id) throws DaoException {
        if (id <= 0) {
            return false;
        }
        final String query = DELETE_USER_BY_ID;
        DBManager dbm;
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            psmt = con.prepareStatement(query);
            psmt.setInt(1, id);
            psmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_DELETE_USER);
            throw new DaoException(Messages.ERR_CANNOT_DELETE_USER, ex);
        } finally {
            DBManager.close(con, psmt);
        }
        return true;
    }

    @Override
    public User getUserByID(int id) throws DaoException {
        final String query = GET_USER_BY_ID;
        User user = null;
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
                user = extractUserFromResultSet(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_OBTAIN_USER_BY_ID, ex);
            throw new DaoException(Messages.ERR_CANNOT_OBTAIN_USER_BY_ID, ex);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) throws DaoException {
        final String query = UPDATE_USER_BY_ID;
        DBManager dbm;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(query);
            int k = 1;
            pstmt.setString(k++, user.getEmail());
            pstmt.setString(k++, user.getFirstName());
            pstmt.setString(k++, user.getLastName());
            pstmt.setString(k++, user.getPassword());
            pstmt.setInt(k, user.getId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_UPDATE_USER);
            throw new DaoException(Messages.ERR_CANNOT_UPDATE_USER, ex);
        } finally {
            DBManager.close(con, pstmt);
        }
        return true;
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
