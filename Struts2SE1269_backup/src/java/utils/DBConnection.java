/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Dell
 */
public class DBConnection {
    public static Connection makeConnection() throws NamingException, SQLException{
        Connection conn = null;
        
        Context context = new InitialContext();
        Context tomcatCtx = (Context)context.lookup("java:comp/env");
        DataSource ds = (DataSource)tomcatCtx.lookup("DBConn");
        if (ds!=null){
            conn = ds.getConnection();
        }
        
        return conn;
    }
}
