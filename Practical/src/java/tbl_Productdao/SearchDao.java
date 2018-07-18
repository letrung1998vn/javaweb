/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_Productdao;

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
import tbl_Productdto.tbl_ProductDTO;
import utils.DBConnection;

/**
 *
 * @author letru
 */
public class SearchDao {

    public List<tbl_ProductDTO> SearchName(String name) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<tbl_ProductDTO> products=new ArrayList<>();
        try {
            con = DBConnection.makeConnection();
            String sql = "Select * from tbl_Product where name=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id=rs.getString("id");
                String description=rs.getString("description");
                float price=rs.getFloat("price");
                Date releasedDate=rs.getDate("releasedDate");
                Date expiredDate=rs.getDate("expiredDate");
                int barCode=rs.getInt("barCode");
                tbl_ProductDTO product=new tbl_ProductDTO(id, name, 
                        description, price, releasedDate, expiredDate, barCode);
                products.add(product);
            }
        } catch (NamingException ex) {
            Logger.getLogger(SearchDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchDao.class.getName()).log(Level.SEVERE, null, ex);
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
        return products;
    }
}
