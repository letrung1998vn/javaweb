<%-- 
    Document   : LoginProcess
    Created on : Jun 15, 2018, 8:57:01 AM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process</title>
    </head>
    <body>
        <h1>Processing</h1>
        <jsp:useBean id="LoginBean" class="sample.javabean.LoginBean"></jsp:useBean>
        <%--<jsp:setProperty name="LoginBean" property="userName" value='<%=request.getParameter("txtUserName") %>'></jsp:setProperty>--%>
        <%--<jsp:setProperty name="LoginBean" property="password" value='<%=request.getParameter("txtPassword") %>'></jsp:setProperty>--%>
        <%--<jsp:setProperty name="LoginBean" property="userName" param="txtUserName"></jsp:setProperty> param la viet tat cua request.getParameter --%>
        <%--<jsp:setProperty name="LoginBean" property="password" param="txtPassword"></jsp:setProperty>--%>
        <%--neu ten cua class cua javabean trung voi ten cua parameter--> khi bo property thi no tu dong scan --%>
        <%--<jsp:setProperty name="LoginBean" property="userName"></jsp:setProperty>--%>
        <%--<jsp:setProperty name="LoginBean" property="password"></jsp:setProperty>--%>
        <jsp:setProperty name="LoginBean" property="*"></jsp:setProperty>
            <!--Detail<br>-->
            <!--User:<jsp:getProperty name="LoginBean" property="userName"></jsp:getProperty><br>-->
        <!--Pass:<jsp:getProperty name="LoginBean" property="password"></jsp:getProperty>-->
        <%--<%
            if (LoginBean.checkLogin()) {
                response.sendRedirect("search.jsp");
            } else {
        %>
        <h2>Invalid userName or Password</h2>
        <%
            }
        %>--%>
        <c:if test="${LoginBean.checkLogin()}">
            <jsp:forward page="search.jsp"></jsp:forward>
        </c:if>
          <h2>Invalid userName or Password</h2>
          <a href="Login.html">Click hear to try again</a>
    </body>
</html>
