<%-- 
    Document   : CreateNewAccount
    Created on : Jun 13, 2018, 8:56:22 AM
    Author     : letru
--%>

<%@page import="sample.registration.RegistrationCreateError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <s:head/>
    </head>
    <body>
        <h1>Create</h1>
        <s:form action="CreateAccount" method="post">
            <s:textfield name="userName" label="UserName"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="confirm" />
            <s:textfield name="fullName" label="fullName"/>
            <s:checkbox name="isAdmin" label="isAdmin" />
            <s:reset value="reset"/>
            <s:submit value="Create" />
        </s:form>
        <s:property value="exception.message"/>
        <s:if test="%{exception.message.indexOf('duplicate')>-1}">
            <font color="red">
            <s:property value="userName"/> is existed!!!
            </font>
        </s:if>
    </body>
</html>
