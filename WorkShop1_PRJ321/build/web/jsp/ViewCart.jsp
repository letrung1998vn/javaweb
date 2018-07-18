<%-- 
    Document   : ViewCart
    Created on : Jun 21, 2018, 11:57:10 PM
    Author     : letru
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Your cart include</h1>
        <c:set var="shoppingCart" value="${sessionScope.CART}"/>
        <c:if test="${not empty shoppingCart}">
            <c:set var="carts" value="${shoppingCart.item}"/>
            <c:if test="${not empty carts}">
                <form action="Dispatcher" method="post">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Mobile Name</th>
                                <th>Quantity</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${carts}" var="cart" varStatus="counter" >
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${cart.key}</td>
                                    <td>${cart.value}</td>
                            <input type="hidden" name="chkItem" value="${cart.key}">
                            <td><input type="checkbox" name="chkItem" value="${cart.key}"></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <input type="hidden" name="who" value="user">
                                <input type="hidden" name="priceMin" value="${param.priceMin}"> 
                                <input type="hidden" name="priceMax" value="${param.priceMax}"> 
                                <input type="submit" name="btnAction" value="Add More Book To Your Cart">
                                <input type="submit" name="btnAction" value="Remove">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
                <form action="Dispatcher">
                    <input type="hidden" name="priceMin" value="${param.priceMin}"> 
                    <input type="hidden" name="priceMax" value="${param.priceMax}"> 
                    <input type="submit" name="btnAction" value="Check Out">
                </form>
            </c:if>
            <c:if test="${empty carts}">
                <h2>Nothing</h2>
                <form action="Dispatcher" method="post">
                    <input type="hidden" name="who" value="user">
                    <input type="hidden" name="priceMin" value="${param.priceMin}"> 
                    <input type="hidden" name="priceMax" value="${param.priceMax}"> 
                    <input type="submit" name="btnAction" value="Add More Book To Your Cart">
                </form>
            </c:if>
        </c:if>
        <c:if test="${empty shoppingCart}">
            <h2>Nothing</h2>
            <form action="Dispatcher" method="post">
                <input type="hidden" name="who" value="user">
                <input type="hidden" name="priceMin" value="${param.priceMin}"> 
                <input type="hidden" name="priceMax" value="${param.priceMax}"> 
                <input type="submit" name="btnAction" value="Add More Book To Your Cart">
            </form>
        </c:if>


    </body>
</html>
