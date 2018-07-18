<%-- 
    Document   : Update
    Created on : Jun 20, 2018, 11:37:37 PM
    Author     : letru
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <s:head/>
    </head>
    <body>
        <h1>Update Page</h1>
        <s:form action="UpdateMobile" method="post">   
            <s:textfield value="%{#parameters.mobileId}" label="mobileId" disabled="true"/>
            <s:hidden name="mobileId" value="%{#parameters.mobileId}"/>
            <s:textfield name="description" value="%{#parameters.description}" label="description"/>
            <s:textfield name="price" value="%{#parameters.price}" label="price"/>
            <s:textfield name="mobileName" value="%{#parameters.mobileName}" label="mobileName"/>
            <s:textfield name="yearOfProduction" value="%{#parameters.yearOfProduction}" label="yearOfProduction"/>
            <s:textfield name="quantity" value="%{#parameters.quantity}" label="quantity"/>
            <s:checkbox name="notSale" value="%{#parameters.notSale}" label="notSale"/>
            <s:submit value="Update"/>
        </s:form>
    </body>
</html>
