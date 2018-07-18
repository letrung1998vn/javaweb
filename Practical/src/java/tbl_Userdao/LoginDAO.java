package tbl_Userdao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import utils.DBConnection;

/**
 *
 * @author letru
 */
public class LoginDAO {
    public boolean checkLogin(String userName, String password) throws SQLException{
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try{
           con=DBConnection.makeConnection();
           String url="Select * from tbl_User where userId=? and password=?";
           stm=con.prepareStatement(url);
           stm.setString(1, userName);
           stm.setString(2, password);
           rs=stm.executeQuery();
           if(rs.next()){
               return true;
           }
        } catch (NamingException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(rs!=null){
                rs.close();
            } if(stm!=null){
                stm.close();
            } if(con!=null){
                con.close();
            }
        }
        return false;
    }
    public int checkwho(String userName, String password) throws SQLException{
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        boolean result;
        try{
           con=DBConnection.makeConnection();
           String url="Select role from tbl_User where userId=? and password=?";
           stm=con.prepareStatement(url);
           stm.setString(1, userName);
           stm.setString(2, password);
           rs=stm.executeQuery();
           if(rs.next()){
               result=rs.getBoolean("role");
               if(result){
                   return 1;
               } else{
                   return 0;
               }
           }
        } catch (NamingException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(rs!=null){
                rs.close();
            } if(stm!=null){
                stm.close();
            } if(con!=null){
                con.close();
            }
        }
        return -1;
    }
}
