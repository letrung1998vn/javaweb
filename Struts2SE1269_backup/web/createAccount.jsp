<%-- 
    Document   : createAccount
    Created on : Jul 9, 2018, 9:31:03 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        <s:head/>
    </head>
    <body>
        <h1>Create new account</h1>
        <s:form action="createAccount" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:textfield name="password" label="Password"/>
            <s:textfield name="confirm" label="Confirm Password"/>
            <s:textfield name="lastname" label="Fullname"/>
            <s:checkbox name="chkAdmin" label="isAdmin"/>
            <s:submit value="Create new account"/>
            <s:reset value="Reset"/>
        </s:form><br>
       <%-- <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <font>
            <s:property value="username"/> is existed!!!
            </font>
        </s:if> --%>
       <s:if test="%{exception.message.contains('duplicate')}">
            <font>
            <s:property value="username"/> is existed!!!
            </font>
        </s:if> 
    </body>
</html>
