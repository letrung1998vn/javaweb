<%-- 
    Document   : Login
    Created on : Jun 25, 2018, 9:26:23 AM
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
        <h1>Login</h1>
        <form action="login.do">
            User Name:<input type="text" name="UserName" value="" /><br>
            Pass Word:<input type="password" name="PassWord" value="" /><br>
            <input type="submit" value="Login">
            <input type="reset" value="reset">
        </form>
    </body>
</html>
