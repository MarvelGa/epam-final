package com.epam.tct.dao.impl;

import com.epam.tct.dao.OrderItemsDAO;
import com.epam.tct.dao.dbmanager.DBManager;
import com.epam.tct.exception.DaoException;
import com.epam.tct.exception.Messages;
import com.epam.tct.model.Distance;
import com.epam.tct.model.Item;
import com.epam.tct.model.Order;
import com.epam.tct.model.OrderItem;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsDAOImpl implements OrderItemsDAO {
    private static final Logger logger = Logger.getLogger(OrderItemsDAOImpl.class);
    private static final String CREATE_ITEM = "INSERT INTO items (city_sender_id, city_recipient_id, max_weight, max_length, max_width, max_height, price, created_at) VALUES (?,?,?,?,?,?,?,?);";
    private static final String CREATE_ORDER = "INSERT INTO orders (user_id, status, created_at) VALUES (?,?,?);";
    private static final String CREATE_ORDER_ITEM = "INSERT INTO order_items (order_id, item_id, distance) VALUES (?,?,?);";
    private static final String GET_ALL_ORDERS_BY_USER_ID = "SELECT o.id, c1.`name`, c2.`name`, d.distance, i.price, i.max_weight, i.max_length, i.max_width, i.max_height, o.created_at, o.`status`\n" +
            "FROM order_items oi, cities c1, cities c2, orders o, items i, distance d\n" +
            "WHERE o.user_id=? AND c1.id = d.city_from_id AND c2.id = d.city_to_id AND o.id=oi.order_id AND i.id=oi.item_id\n" +
            "\tAND i.city_sender_id= c1.id AND i.city_recipient_id=c2.id\n" +
            "ORDER BY o.id ASC;";

    @Override
    public int createOrder(Order order, Item item, double distance) throws DaoException {
        int itemId =-1;
        int orderId =-1;
        int orderItemId =-1;

        DBManager dbm;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(CREATE_ITEM, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, item.getCitySender());
            pstmt.setInt(2, item.getCityRecipeint());
            pstmt.setDouble(3, item.getMaxWeight());
            pstmt.setDouble(4, item.getMaxLength());
            pstmt.setDouble(5, item.getMaxWidth());
            pstmt.setDouble(6, item.getMaxHeight());
            pstmt.setDouble(7, item.getPrice());
            pstmt.setTimestamp(8, Timestamp.valueOf(item.getCreatedAt()));

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                itemId = rs.getInt(1);
            }


            pstmt = con.prepareStatement(CREATE_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, order.getUser_id());
            pstmt.setString(2, String.valueOf(order.getStatus()));
            pstmt.setString(3, String.valueOf(order.getCreatedAt()));
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                orderId = rs.getInt(1);
            }

            pstmt = con.prepareStatement(CREATE_ORDER_ITEM, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, itemId);
            pstmt.setDouble(3, item.getPrice());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                orderItemId = rs.getInt(1);
            }

            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_INSERT_ORDER, ex);
            throw new DaoException(Messages.ERR_CANNOT_INSERT_ORDER, ex);
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return orderItemId;
    }

    @Override
    public List<OrderItem> getAllDeliveriesOrdersByUserID(int id) throws DaoException {
        final String query = GET_ALL_ORDERS_BY_USER_ID;
        List<OrderItem> listOfUserOrders = new ArrayList<>();
        DBManager dbm;
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            dbm = DBManager.getInstance();
            con = dbm.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                Order order = new Order();
                OrderItem orderItem = new OrderItem();
                order.setId(rs.getInt(1));
                item.setCityFrom(rs.getString(2));
                item.setCityTo(rs.getString(3));
                orderItem.setDistance(rs.getDouble(4));
                item.setPrice(rs.getDouble(5));
                item.setMaxWeight(rs.getDouble(6));
                item.setMaxLength(rs.getDouble(7));
                item.setMaxWidth(rs.getDouble(8));
                item.setMaxHeight(rs.getDouble(9));
                order.setCreatedAt(LocalDateTime.parse(rs.getString(10)));
                order.setStatus(Order.OrderStatus.valueOf(rs.getString(11)));
                orderItem.setOrder(order);
                orderItem.setItem(item);
                listOfUserOrders.add(orderItem);
            }
            con.commit();
        } catch (SQLException ex) {
            DBManager.rollback(con);
            logger.error(Messages.ERR_CANNOT_GET_ALL_ORDERS_BY_USER_ID, ex);
            throw new DaoException(Messages.ERR_CANNOT_GET_ALL_ORDERS_BY_USER_ID, ex);
        } finally {
            DBManager.close(con, stmt, rs);
        }
        return listOfUserOrders;

    }
}
