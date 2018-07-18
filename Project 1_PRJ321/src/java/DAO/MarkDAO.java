/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Obj.MarkObj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import sun.security.pkcs11.Secmod;
import util.DBUtils;

/**
 *
 * @author letru
 */
public class MarkDAO {

    public List<MarkObj> showMark(String studentId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MarkObj> marks = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            String sql = "select subjectID,blockSemester,subjectAvg,status from marks where studentID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, studentId);
            rs = stm.executeQuery();
            while (rs.next()) {
                String subjectID = rs.getString("subjectID");
                String blockSemester = rs.getString("blockSemester");
                StringTokenizer stk = new StringTokenizer(blockSemester, "0123456789");
                String semester = stk.nextToken();
                StringTokenizer stk1 = new StringTokenizer(blockSemester, semester);
                StringTokenizer stk2 = new StringTokenizer(stk1.nextToken(), "_");
                String year1 = stk2.nextToken();
                float year = Float.parseFloat(year1);
                String block1 = stk2.nextToken();
                int block = Integer.parseInt(block1);
                float subjectAvg = rs.getFloat("subjectAvg");
                String status = rs.getString("status");
                marks.add(new MarkObj(subjectID, block,
                        semester, year, subjectAvg, status));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return marks;
    }

    public List<MarkObj> ViewMark(String studentId, String subjectID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MarkObj> marks = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            String sql = "select blockSemester,status from marks where studentID=? and subjectID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, studentId);
            stm.setString(2, subjectID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String blockSemester = rs.getString("blockSemester");
                StringTokenizer stk = new StringTokenizer(blockSemester, "0123456789");
                String semester = stk.nextToken();
                StringTokenizer stk1 = new StringTokenizer(blockSemester, semester);
                StringTokenizer stk2 = new StringTokenizer(stk1.nextToken(), "_");
                String year1 = stk2.nextToken();
                float year = Float.parseFloat(year1);
                String block1 = stk2.nextToken();
                int block = Integer.parseInt(block1);
                String status = rs.getString("status");
                marks.add(new MarkObj(block, semester,
                        year, status));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return marks;
    }

    public int showPassCredit(String studentId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int passCredit = 0;
        SubjectDAO dao = new SubjectDAO();
        ArrayList<String> subjects = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            String sql = "select subjectID,status from marks where studentID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, studentId);
            rs = stm.executeQuery();
            while (rs.next()) {
                String status = rs.getString("status");
                String subjectID = rs.getString("subjectID");
                if (status.equals("Pass")) {
                    if (!subjects.contains(subjectID)) {
                        subjects.add(subjectID);
                        int credit = dao.searchCredit(subjectID);
                        passCredit += credit;
                    }
                }
                if (status.equals("Improved")) {
                    if (!subjects.contains(subjectID)) {
                        subjects.add(subjectID);
                        int credit = dao.searchCredit(subjectID);
                        passCredit += credit;
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return passCredit;
    }

    public Map<String, Integer> showCredit(List<MarkObj> marks) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map<String, Integer> credits = new HashMap<>();
        SubjectDAO dao = new SubjectDAO();
        ArrayList<String> subjects = new ArrayList<>();
        try {
            for (MarkObj mark : marks) {
                String subjectID = mark.getSubjectID();
                if (!subjects.contains(subjectID)) {
                    subjects.add(subjectID);
                    int credit = dao.searchCredit(subjectID);
                    credits.put(subjectID, credit);
                }
            }
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
        return credits;
    }

    public List<MarkObj> showMarkFeedBack(String studentId, String subjectID) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MarkObj> marks = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            String sql = "select subjectAvg,status from marks where studentID=? and subjectID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, studentId);
            stm.setString(2, subjectID);
            rs = stm.executeQuery();
            while (rs.next()) {
                float subjectAvg = rs.getFloat("subjectAvg");
                String status = rs.getString("status");
                marks.add(new MarkObj(subjectID, subjectAvg, status));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return marks;
    }
}
