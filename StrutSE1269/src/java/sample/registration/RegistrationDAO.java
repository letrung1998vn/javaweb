/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import registration.RegistrationDTO;
import sample.util.DBUtils;

/**
 *
 * @author letru
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String userName, String Password) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "Select * from Registration where UserName=? and Password=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, Password);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    private List<RegistrationDTO> listAccount;

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    public void searchLastName(String SearchValue) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Registration where Lastname like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + SearchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userName = rs.getString("UserName");
                    String password = rs.getString("Password");
                    String lastName = rs.getString("LastName");
                    boolean role = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(userName, password, lastName, role);
                    if (this.listAccount == null) {
                        this.listAccount = new ArrayList<>();
                    }
                    this.listAccount.add(dto);
                }
            }
        } catch (Exception e) {
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
    }

    public boolean DeleteAccount(String userName)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Delete from Registration where UserName=? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userName);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }

            }
        } catch (Exception e) {
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

    public boolean UpdateAccount(String userName, String PassWord, int role, String OldUserName)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update Registration set UserName=?,Password=?,isAdmin=? where UserName=?;";
                stm = con.prepareStatement(sql);
                stm.setString(1, userName);
                stm.setString(2, PassWord);
                stm.setInt(3, role);
                stm.setString(4, OldUserName);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean createAccount(String userName, String password,
            String fullName, boolean role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "insert into Registration "
                        + "(UserName,Password,Lastname,isAdmin)"
                        + "values(?,?,?,?) ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userName);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setBoolean(4, role);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
}
