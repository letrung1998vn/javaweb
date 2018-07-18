<%-- 
    Document   : Search
    Created on : Jun 19, 2018, 3:46:29 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        Welcome ${sessionScope.USERNAME}<br>
        <h1>Search Page</h1>
        <form action="Dispatcher" method="post">    
            <input type="hidden" name="who" value="staff">
            <input type="text" name="SearchValue" 
                   <c:if test="${not empty param.SearchValue}">
                       value="${param.SearchValue}"
                   </c:if>
                   <c:if test="${empty param.SearchValue}">
                       value="${param.mobileId}"
                   </c:if>
                   >
            ID<input type="radio" name="filter" value="id"
                     <c:if test="${requestScope.id}">
                         checked="checked"
                     </c:if>>
            NAME<input type="radio" name="filter" value="name" 
                       <c:if test="${requestScope.name}">
                           checked="checked"
                       </c:if>><br>
            <input type="submit" name="btnAction" value="Search">
        </form>
        <form action="Dispatcher" method="post">
            <input type="hidden" name="filter" value="${param.filter}">
            <c:if test="${empty filter}">
                <input type="hidden" name="filter" value="${requestScope.id}">
                <c:if test="${empty filter}">
                    <input type="hidden" name="filter" value="${requestScope.name}">
                </c:if>
            </c:if>
            <input type="submit" name="btnAction" value="Insert">
        </form>
        <c:set var="filter" value="${param.filter}"/>
        <c:if test="${empty filter}">
            <c:set var="filter" value="${requestScope.id}"/>
            <c:if test="${empty filter}">
                <c:set var="filter" value="${requestScope.name}"/>
            </c:if>
        </c:if>
        <c:if test="${not empty filter}">
            <c:set var="SearchValue" value="${param.SearchValue}"/>
            <c:if test="${empty param.SearchValue}">
                <c:set var="SearchValue"  value="${param.mobileId}"/>
            </c:if>
            <c:if test="${not empty SearchValue}"> 
                <c:set var="mobiles" value="${requestScope.mobiles}"/>
                <c:if test="${not empty mobiles}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>mobile Id</th>
                                <th>description</th>
                                <th>price</th>
                                <th>mobile Name</th>
                                <th>year Of Production</th>
                                <th>quantity</th>
                                <th>not Sale</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${mobiles}" var="mobile" varStatus="counter">
                            <form action="Dispatcher" method="post">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${mobile.mobileId}
                                        <input type="hidden" value="${mobile.mobileId}" name="mobileId">
                                    </td>
                                    <td>
                                        ${mobile.description}
                                        <input type="hidden" value="${mobile.description}" name="description">
                                    </td>
                                    <td>
                                        ${mobile.price}
                                        <input type="hidden" value="${mobile.price}" name="price">
                                    </td>
                                    <td>
                                        ${mobile.mobileName}
                                        <input type="hidden" value="${mobile.mobileName}" name="mobileName">
                                    </td>
                                    <td>
                                        ${mobile.yearOfProduction}
                                        <input type="hidden" value="${mobile.yearOfProduction}" name="yearOfProduction">
                                    </td>
                                    <td>
                                        ${mobile.quantity}
                                        <input type="hidden" value="${mobile.quantity}" name="quantity">
                                    </td>
                                    <td>   
                                        <input type="checkbox" disabled="disabled" 
                                               <c:if test="${mobile.notSale}">
                                                   checked="checked"                            
                                               </c:if>
                                               >
                                        <input type="hidden"name="notSale" value="${mobile.notSale}" >
                                    </td>
                                <input type="hidden" name="SearchValue" value="${param.SearchValue}">
                                <input type="hidden" name="filter" value="${param.filter}">
                                <c:if test="${empty filter}">
                                    <input type="hidden" name="filter" value="${requestScope.id}">
                                    <c:if test="${empty filter}">
                                        <input type="hidden" name="filter" value="${requestScope.name}">
                                    </c:if>
                                </c:if>
                                <td>
                                    <input type="submit" name="btnAction" value="Delete">
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Update">
                                </td>
                                </tr> 
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty mobiles}">
                <h1>No matches</h1>
            </c:if>
        </c:if>
    </c:if>
</body>
</html>
