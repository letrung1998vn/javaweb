/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.DBUtil;
import java.util.logging.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author letru
 */
public class LoginDAO {

    public int checkLogin(String userName, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int role = 4;
        try {
            con = DBUtil.makeConnection();
            String sql = "Select * from tbl_User where userId=? and password=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                role = rs.getInt("role");
                return role;
            }
        } catch (SQLException e) {
            Logger.getLogger("LoginDAO_SQL " + e.getMessage());
        } catch (ClassNotFoundException e) {
             Logger.getLogger("LoginDAO_ClassNotFound " + e.getMessage());
        } catch (NamingException e) {
             Logger.getLogger("LoginDAO_Naming " + e.getMessage());
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
        return 4;
    }
}
