<%-- 
    Document   : LoginError
    Created on : Jul 5, 2018, 8:59:39 PM
    Author     : letru
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login error</title>
    </head>
    <body>
        <c:url value="Login.jsp" var="Login">
            <c:param name="userName" value="${param.userName}"/>
        </c:url>
        <h1>Invalid UserName or PassWord!!!</h1>
        Click <a href="${Login}">here</a> to return login page
    </body>
</html>
