/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import util.DBUtils;

/**
 *
 * @author letru
 */
public class LoginDAO {

    public boolean checkLogin(String userName, String password) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "Select username,password,status from account where username=? and password=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                if (!rs.getString("status").equals("dropout")) {
                    return true;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("LoginDAO_CheckLogin_ClassNotFound: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger("LoginDAO_CheckLogin_SQL: " + ex.getMessage());
        } catch (NamingException ex) {
            Logger.getLogger("LoginDAO_CheckLogin_Naming: " + ex.getMessage());
        } finally {

        }
        return false;
    }
    
}
