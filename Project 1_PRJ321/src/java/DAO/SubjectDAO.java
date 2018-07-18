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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import util.DBUtils;

/**
 *
 * @author letru
 */
public class SubjectDAO {

    public Map<String, String> showSubjectName() throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map<String, String> subject = new HashMap<>();
        try {
            con = DBUtils.makeConnection();
            String sql = "select subjectID, subjectName from subject";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String subjectID = rs.getString("subjectID");
                String subjectName = rs.getString("subjectName");
                subject.put(subjectID, subjectName);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return subject;
    }

    public String searchSubjectName(String subjectID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String subjectName = "";
        try {
            con = DBUtils.makeConnection();
            String sql = "select subjectName from subject where  subjectID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, subjectID);
            rs = stm.executeQuery();
            while (rs.next()) {
                subjectName = rs.getString("subjectName");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return subjectName;
    }
    public int searchCredit(String subjectID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int credit = 0;
        try {
            con = DBUtils.makeConnection();
            String sql = "select credits from subject where subjectID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, subjectID);
            rs = stm.executeQuery();
            if (rs.next()) {
                credit=rs.getInt("credits");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return credit;
    }
}
