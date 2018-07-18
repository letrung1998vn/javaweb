/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.tbl_MoblieDTO;
import Util.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author letru
 */
public class OrderDAO {

    public boolean InsertOrderDetail(OrderDetailDTO orderDetail) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "insert into tbl_OrderDetails "
                    + "(OrderId,mobileId,UnitPrice,Quantity)"
                    + " values(?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, orderDetail.getOrderId());
            stm.setString(2, orderDetail.getMobileId());
            stm.setInt(3, orderDetail.getUnitPrice());
            stm.setInt(4, orderDetail.getQuantity());
            int result=stm.executeUpdate();
            if (result>0) {
                return true;
            }
        } 
        catch (SQLException e) {
            Logger.getLogger("MobileDAO_SearchName_SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_SearchName_ClassNotFounf " + e.getMessage());
        } catch (NamingException e) {
            Logger.getLogger("MobileDAO_SearchName_Naming " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean InsertOrder(OrderDTO order) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "insert tbl_Order (OrderId, UserId ,RequiredDate, Freight)"
                    + " values(?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, order.getOrderId());
            stm.setString(2, order.getUserId());
            stm.setDate(3, order.getOrderDate());
            stm.setInt(4, order.getFreight());
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger("MobileDAO_SearchName_SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_SearchName_ClassNotFounf " + e.getMessage());
        } catch (NamingException e) {
            Logger.getLogger("MobileDAO_SearchName_Naming " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public List<OrderDTO> ShowOrder() throws SQLException {
        List<OrderDTO> orders = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<tbl_MoblieDTO> mobiles = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            String sql = "Select * from  tbl_Order ";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String OrderId = rs.getString("OrderId");
                String UserId = rs.getString("UserId");
                Date OrderDate = rs.getDate("OrderDate");
                int Freight = rs.getInt("Freight");
                orders.add(new OrderDTO(OrderId, UserId, OrderDate, Freight));
            }
        } catch (SQLException e) {
            Logger.getLogger("MobileDAO_SearchName_SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_SearchName_ClassNotFounf " + e.getMessage());
        } catch (NamingException e) {
            Logger.getLogger("MobileDAO_SearchName_Naming " + e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return orders;
    }

}
