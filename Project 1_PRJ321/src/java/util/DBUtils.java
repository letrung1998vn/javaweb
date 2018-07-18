/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author letru
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() throws ClassNotFoundException, SQLException, NamingException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url="jdbc:sqlserver://localhost:1433;databaseName=SV2018";
//        Connection con=DriverManager.getConnection(url,"sa","123456");
//        return con;
        Context context = new InitialContext();
        Context tomcatCtx = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatCtx.lookup("Connection");
        Connection con = ds.getConnection();
        return con;
    }
}
