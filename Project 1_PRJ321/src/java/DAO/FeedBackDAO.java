/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FeedBackDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import util.DBUtils;

/**
 *
 * @author letru
 */
public class FeedBackDAO {

    public boolean addFeedBack(FeedBackDTO feedBack) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "Insert into feedback (fbDate,contents,studentID,status)"
                    + " values(?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setDate(1, (Date) feedBack.getFbDate());
            stm.setString(2, feedBack.getContents());
            stm.setString(3, feedBack.getStudentID());
            stm.setBoolean(4, feedBack.isStatus());
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeedBackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FeedBackDAO.class.getName()).log(Level.SEVERE, null, ex);
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
