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
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import util.DBUtils;

/**
 *
 * @author letru
 */
public class StudentDAO {
    public String SearchStudentName(String studentId) throws SQLException{
          Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs=null;
        String name="";
        try {
            con = DBUtils.makeConnection();
            String sql = "select firstName,lastName,middleName from student where studentID=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, studentId);
            rs = stm.executeQuery();
            if (rs.next()) {
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String middleName=rs.getString("middleName");
                name=firstName+" "+middleName+" "+lastName;
                if(middleName==null){
                    name=firstName+" "+lastName;
                }else if(lastName==null){
                     name=firstName+" "+middleName;
                } else if(firstName==null){
                      name=middleName+" "+lastName;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MarkDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return name;
    }
}
