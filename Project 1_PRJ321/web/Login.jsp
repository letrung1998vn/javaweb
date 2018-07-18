<%-- 
    Document   : Login
    Created on : Jul 5, 2018, 8:56:10 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
      <div>
            <h1>Login Page</h1>
            <form action="login" method="post">
                <table>
                    <tr>
                        <td>UserName:</td>
                        <td><input type="text" name="userName" value="${param.userName}"></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" style="width: 100px; height: 20px; margin-right:0px">Login</button>
                        </td>
                        <td>
                            <button type="reset" style="width: 100px; height: 20px; margin-left: 0px">Reset</button>
                        </td>
                    </tr>
                </table>                      
            </form>
        </div>
    </body>
</html>
