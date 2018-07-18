<%-- 
    Document   : CheckOut
    Created on : Jun 23, 2018, 12:03:01 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>
        <h1>Order</h1>
        <form action="Dispatcher">
            <table>
                `<tr>
                    <td>
                        Order ID
                    </td>
                    <td>
                        <input type="text" disabled="disabled"
                               <c:set var="orders" value="${requestScope.orders}" />
                               <c:if test="${not empty orders}">
                                   <c:forEach var="order" items="${orders}">
                                       <c:set var="orderId" value="${order.orderId}"/>
                                   </c:forEach>
                                   value="${orderId+1}"
                               </c:if>
                               <c:if test="${empty orders}">
                                   value="1"
                               </c:if>
                               >
                        <input type="hidden" name="orderId"
                               <c:set var="orders" value="${requestScope.orders}" />
                               <c:if test="${not empty orders}">
                                   value="${orderId+1}"
                               </c:if>
                               <c:if test="${empty orders}">
                                   value="1"
                               </c:if> >
                    </td>
                </tr>
                <c:set var="shoppingCart" value="${sessionScope.CART}"/>
                <c:set var="carts" value="${shoppingCart.item}"/>
                <c:forEach items="${carts}" var="cart">
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td>Product:${cart.key}</td>
                        <td>Quantity:${cart.value}</td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                </c:forEach>
                <tr>
                    <td>
                        User Id
                    </td>
                    <td>
                        <input type="text" value="${sessionScope.USERNAME}" disabled="disabled">
                        <input type="hidden" name="userId"  value="${sessionScope.USERNAME}">
                    </td>
                </tr>
                <tr>
                    <td>
                        Required Date
                    </td>
                    <td>
                        <input type="date" name="requiredDate" value="2018-06-28">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Freight
                        </td>
                        <td>
                            <input type="text" value="${requestScope.total}" disabled="disabled">
                        <input type="hidden" name="freight" value="${requestScope.total}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btnAction" value="Order">
                        <input type="hidden" name="priceMin" value="${param.priceMin}"> 
                        <input type="hidden" name="priceMax" value="${param.priceMax}"> 
                        <input type="submit" name="btnAction" value="View Your Cart">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
