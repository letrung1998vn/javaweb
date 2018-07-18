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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author letru
 */
public class MobileDAO {

    public List<tbl_MoblieDTO> SearchID(String mobileId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<tbl_MoblieDTO> mobiles = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            String sql = "Select * from  tbl_Mobile where mobileId=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, mobileId);
            rs = stm.executeQuery();
            if (rs.next()) {
                String mobileID = rs.getString("mobileId");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String mobileName = rs.getString("mobileName");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                mobiles.add(new tbl_MoblieDTO(mobileID, description, price,
                        mobileName, yearOfProduction, quantity, notSale));
            }
        } catch (SQLException e) {
            Logger.getLogger("MobileDAO_SearchID_SQL " + e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_SearchID_ClassNotFound "
                    + e.getMessage());
        } catch (NamingException e) {
            Logger.getLogger("MobileDAO_SearchId_Naming " + e.getMessage());
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
        return mobiles;
    }

    public List<tbl_MoblieDTO> SearchName(String mobilename) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<tbl_MoblieDTO> mobiles = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            String sql = "Select * from  tbl_Mobile where mobileName like ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + mobilename + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String mobileName = rs.getString("mobileName");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                mobiles.add(new tbl_MoblieDTO(mobileId, description, price,
                        mobileName, yearOfProduction, quantity, notSale));
            }
        } catch (SQLException e) {
            Logger.getLogger("MobileDAO_SearchName_SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_SearchName_ClassNotFounf "
                    + e.getMessage());
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
        return mobiles;
    }

    public boolean DeleteMobile(String mobileId)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "Delete from tbl_Mobile where mobileId=? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, mobileId);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }

            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_UpdateMobile_ClassNotFound "
                    + e.getMessage());
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

    public boolean UpdateMobile(tbl_MoblieDTO Mobile)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "update tbl_Mobile set description=?, price=?,"
                        + "mobileName=?, yearOfProduction=?, quantity=?, "
                        + "notSale=? where mobileId=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, Mobile.getDescription());
                stm.setFloat(2, Mobile.getPrice());
                stm.setString(3, Mobile.getMobileName());
                stm.setInt(4, Mobile.getYearOfProduction());
                stm.setInt(5, Mobile.getQuantity());
                stm.setBoolean(6, Mobile.isNotSale());
                stm.setString(7, Mobile.getMobileId());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_UpdateMobile_ClassNotFound "
                    + e.getMessage());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean InsertMobile(tbl_MoblieDTO Mobile)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "insert into tbl_Mobile (description, price,"
                        + "mobileName, yearOfProduction, quantity, "
                        + "notSale,mobileId) values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, Mobile.getDescription());
                stm.setFloat(2, Mobile.getPrice());
                stm.setString(3, Mobile.getMobileName());
                stm.setInt(4, Mobile.getYearOfProduction());
                stm.setInt(5, Mobile.getQuantity());
                stm.setBoolean(6, Mobile.isNotSale());
                stm.setString(7, Mobile.getMobileId());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_UpdateMobile_ClassNotFound "
                    + e.getMessage());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public List<tbl_MoblieDTO> SearchMobileByPrice(float minPrice, float maxPrice) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<tbl_MoblieDTO> mobiles = new ArrayList<>();
        try {
            con = DBUtil.makeConnection();
            String sql = "Select * from  tbl_Mobile "
                    + "where price between ? and ? ";
            stm = con.prepareStatement(sql);
            stm.setFloat(1, minPrice);
            stm.setFloat(2, maxPrice);
            rs = stm.executeQuery();
            while (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String mobileName = rs.getString("mobileName");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                mobiles.add(new tbl_MoblieDTO(mobileId, description, price,
                        mobileName, yearOfProduction, quantity, notSale));
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
        return mobiles;
    }

    public tbl_MoblieDTO SearchPrice(String mobileName) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        tbl_MoblieDTO mobile = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "Select price from  tbl_Mobile "
                    + "where mobileName=? ";
            stm = con.prepareStatement(sql);
            stm.setString(1, mobileName);
            rs = stm.executeQuery();
            if (rs.next()) {
                mobile = new tbl_MoblieDTO(rs.getInt("price"), mobileName);
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
        return mobile;
    }

    public boolean UpdateQuantity(String mobileName, int quantity)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                String sql = "update tbl_Mobile set quantity=? "
                        + "where mobileName=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, mobileName);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        }
        catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_UpdateMobile_ClassNotFound "
                    + e.getMessage());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
     public tbl_MoblieDTO SearchMobileName(String mobilename) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        tbl_MoblieDTO mobile = null;
        try {
            con = DBUtil.makeConnection();
            String sql = "Select * from  tbl_Mobile where mobileName=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, mobilename);
            rs = stm.executeQuery();
            if (rs.next()) {
                String mobileId = rs.getString("mobileId");
                String mobileName = rs.getString("mobileName");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int quantity = rs.getInt("quantity");
                boolean notSale = rs.getBoolean("notSale");
                mobile=new tbl_MoblieDTO(mobileId, description, price, mobileName, 
                        yearOfProduction, quantity, notSale);
            }
        }
        catch (SQLException e) {
            Logger.getLogger("MobileDAO_SearchName_SQL" + e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger("MobileDAO_SearchName_ClassNotFounf "
                    + e.getMessage());
        } catch (NamingException e) {
            Logger.getLogger("MobileDAO_SearchName_Naming " + e.getMessage());
        } 
        finally {
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
        return mobile;
    }
}
