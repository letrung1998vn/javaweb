<%-- 
    Document   : Insert
    Created on : Jun 21, 2018, 1:47:55 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
        <s:head/>
    </head>
    <body>
        <h1>Insert Page</h1>
        <s:form action="submitInsert">
            <s:textfield name="mobileId" value="%{mobileId}" label="mobileId"/>
            <s:textfield name="description" value="%{description}" label="description"/>
            <s:textfield name="price" value="%{price}" label="price"/>
            <s:textfield name="mobileName" value="%{mobileName}" label="mobileName"/>
            <s:textfield name="yearOfProduction" value="%{yearOfProduction}" label="yearOfProduction"/>
            <s:textfield name="quantity" value="%{quantity}" label="quantity"/>
            <s:checkbox name="notSale" value="%{notSale}" label="notSale"/>
            <s:submit value="Insert"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate')>-1}">
            <font color="red">
            <h1><s:property value="%{mobileId}"/> is Existed</h1>
            </font>
        </s:if>
    </body>
</html>
