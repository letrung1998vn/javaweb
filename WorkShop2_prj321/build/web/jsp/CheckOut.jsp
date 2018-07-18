<%-- 
    Document   : CheckOut
    Created on : Jun 23, 2018, 12:03:01 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
        <s:head/>
    </head>
    <body>
        <h1>Order</h1>
        <s:form action="InsertOrder">
            <s:textfield value="%{orderId}" label="Order ID" disabled="true"/>
            <s:hidden name="orderId" value="%{orderId}" />
            <s:iterator value="%{#session.cart.item}">
                <s:textfield value="%{key}" label="Mobile Name" disabled="true"/>
                <s:textfield value="%{value}" label="Quantity" disabled="true"/>
            </s:iterator>
            <s:textfield value="%{#session.USERNAME}" label="User Id" disabled="true"/>
            <s:hidden name="userId" value="%{#session.USERNAME}" />
            <s:textfield value="%{total}" label="Frieght" disabled="true"/>
            <s:hidden name="freight" value="%{total}"/>
            <s:submit value="Submit"/>
        </s:form> 
    </body>
</html>
