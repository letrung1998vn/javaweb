<%-- 
    Document   : UserSearch
    Created on : Jun 19, 2018, 4:38:06 PM
    Author     : letru
--%>

<%@page import="DTO.tbl_MoblieDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <h1>Search Page</h1>
        <form action="Dispatcher">
            <input type="hidden" name="who" value="user">
            Search Value: 
            Min<input type="text" name="priceMin" value="${param.priceMin}"> 
            Max <input type="text" name="priceMax" value="${param.priceMax}">
            <input type="submit" name="btnAction" value="Search">
        </form>
        <c:set var="mobiles" value="${requestScope.mobiles}"/>
        <c:if test="${not empty param.priceMin}">
            <c:if test="${not empty param.priceMax}">
                <c:if test="${not empty mobiles}">
                    <c:set var="shoppingCart" value="${sessionScope.CART}"/>
                    <c:set var="carts" value="${shoppingCart.item}"/>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Mobile Id</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th>Mobile Name</th>
                                <th>Year Of Production</th>
                                <th>Quantity</th>
                                <th>Not Sale</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${mobiles}" var="mobile">
                            <form action="Dispatcher" method="post">
                                <tr>
                                    <td>${mobile.mobileId}</td>
                                    <td>${mobile.description}</td>
                                    <td>${mobile.price}</td>
                                    <td>${mobile.mobileName}</td>
                                <input type="hidden" name="mobileName" value="${mobile.mobileName}">
                                <td>${mobile.yearOfProduction}</td>
                                <td>
                                    <c:if test="${not empty carts}">
                                        <c:forEach var="cart" items="${carts}">
                                            <c:if test="${mobile.mobileName==cart.key}">
                                                <c:set var="add" value="${mobile.mobileName}"/>
                                                <c:set var="quantityLeft" value="${mobile.quantity-cart.value}"/>
                                                ${mobile.quantity-cart.value}
                                            </td>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${add!=mobile.mobileName}">
                                    ${mobile.quantity}
                                     </td>
                                </c:if>            
                                <td>
                                    <input type="checkbox" disabled="disabled"
                                           <c:if test="${mobile.notSale}">
                                               checked="checked"
                                           </c:if>
                                           >
                                </td>
                                <td>
                                    <input type="hidden" name="priceMin" value="${param.priceMin}"> 
                                    <input type="hidden" name="priceMax" value="${param.priceMax}">                                 
                                    <input type="submit" name="btnAction" value="Add to Cart"
                                           <c:if test="${quantityLeft<=0}">
                                               <c:remove var="quantityLeft"/>
                                               disabled="disabled"
                                           </c:if>
                                           <c:if test="${mobile.notSale}">
                                               disabled="disabled"
                                           </c:if>
                                           > 
                                </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>
    </c:if>
    <form action="Dispatcher" method="post">
        <input type="hidden" name="priceMin" value="${param.priceMin}"> 
        <input type="hidden" name="priceMax" value="${param.priceMax}"> 
        <input type="submit" name="btnAction" value="View Your Cart">
    </form>
</body>
</html>
