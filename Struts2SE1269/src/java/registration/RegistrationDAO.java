/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBConnection;

/**
 *
 * @author Dell
 */
public class RegistrationDAO implements Serializable{
    public boolean checkLogin(String username, String password) throws SQLException, NamingException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.makeConnection();
            if(conn!=null){
                String sql = "Select * from Registration where username=?"
                        + " and password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                
                if(rs.next())
                    check = true;
            }
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return check;
    }
    List<RegistrationDTO> listAccounts;

    public List<RegistrationDTO> getListAccounts() {
        return listAccounts;
    }
    
    public void searchLastName(String searchValue) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.makeConnection();
            if(conn!=null){
                String sql = "select * from Registration where lastname Like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                while(rs.next()){
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    if(listAccounts==null){
                        listAccounts = new ArrayList<>();
                    }
                    listAccounts.add(new RegistrationDTO(username, password, lastname, role));
                }
            }
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
    public boolean deleteAccount(String username) throws NamingException, SQLException{
        boolean check =false;
        Connection conn = null;
        PreparedStatement stm = null;
        try{
            conn = DBConnection.makeConnection();
            if(conn!=null){
                String sql = "delete from Registration where username = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                
                int row = stm.executeUpdate();
                
                if(row>0){
                    check = true;
                }
            }
        }
        finally{          
            if(stm!=null){
                stm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return check;
    }
    public boolean updateAccount(String username, String password, boolean role) throws SQLException, NamingException{
        boolean check =false;
        Connection conn = null;
        PreparedStatement stm = null;
        try{
            conn = DBConnection.makeConnection();
            if(conn!=null){
                String sql = "update Registration set password=?, isAdmin=? where username=?";
                
                stm = conn.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);
                
                int row = stm.executeUpdate();
                
                if(row>0){
                    check = true;
                }
            }
        }
        finally{          
            if(stm!=null){
                stm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return check;
    }
    public boolean createAccount(String username, String password, String fullName, boolean role) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        
        try{
            conn = DBConnection.makeConnection();
            if(conn!=null){
                String sql = "insert into "
                        + "Registration (username, password, lastname, isAdmin)"
                        + " values (?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setBoolean(4, role);
                
                if(stm.executeUpdate()>0){
                    return true;
                }
            }
        }
        finally{
            
            if(stm!=null){
                stm.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return false;
    }
    
    
}
