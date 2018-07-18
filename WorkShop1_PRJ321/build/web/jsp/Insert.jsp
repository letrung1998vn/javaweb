<%-- 
    Document   : Insert
    Created on : Jun 21, 2018, 1:47:55 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
    </head>
    <body>
        <h1>Insert Page</h1>
        <c:set var="errors" value="${requestScope.errors}"/>
        <form action="Dispatcher" method="post">
            <table>
                <tr>
                    <td>
                        Mobile Id<input type="text" name="mobileId" value="${param.mobileId}">
                    </td>
                </tr>
                <c:if test="${not empty errors.mobileIdLengthError}">
                    <tr>
                        <td>
                            <h3>
                                ${errors.mobileIdLengthError}
                            </h3>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        description<input type="text" name="description" value="${param.description}">
                    </td>
                </tr>
                <c:if test="${not empty errors.descriptionLengthError}">
                    <tr>
                        <td>
                            <h3>
                                ${errors.descriptionLengthError}
                            </h3>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        price<input type="text" name="price" value="${param.price}">
                    </td>
                </tr>
                <c:if test="${not empty errors.priceError}">
                    <tr>
                        <td>
                            <h3>
                                ${errors.priceError}
                            </h3>
                        </td>
                    </tr>
                </c:if>
                </tr>
                <tr>
                    <td>
                        Mobile Name<input type="text" name="mobileName" value="${param.mobileName}">
                    </td>
                </tr>
                <c:if test="${not empty errors.mobileNameError}">
                    <tr>
                        <td>
                            <h3>
                                ${errors.mobileNameError}
                            </h3>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        Year Of Production<input type="text" name="yearOfProduction" value="${param.yearOfProduction}">
                    </td>
                </tr>
                <c:if test="${not empty errors.yearofProductionError}">
                    <tr>
                        <td>
                            <h3>
                                ${errors.yearofProductionError}
                            </h3>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        quantity<input type="text" name="quantity" value="${param.quantity}">
                    </td>
                </tr>
                <c:if test="${not empty errors.quantityError}">
                    <tr>
                        <td>
                            <h3>
                                ${errors.quantityError}
                            </h3>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        Not Sale<input type="checkbox" name="notSale" 
                                       <c:if test="${param.notSale}">
                                           checked="checked"
                                       </c:if>>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" name="SearchValue" value="${param.SearchValue}">
                        <input type="hidden" name="filter" value="${param.filter}">
                        <c:if test="${empty filter}">
                            <input type="hidden" name="filter" value="${requestScope.id}">
                            <c:if test="${empty filter}">
                                <input type="hidden" name="filter" value="${requestScope.name}">
                            </c:if>
                        </c:if>
                        <input type="submit" name="btnAction" value="Insert Mobile">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
