<%-- 
    Document   : Update
    Created on : Jun 20, 2018, 11:37:37 PM
    Author     : letru
--%>

<%@page import="Error.UpdateError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <c:set var="errors" value="${requestScope.errors}"/>
        <form action="Dispatcher" method="post">
            <table>
                <tr>
                    <td>Mobile ID<input type="text" disabled="disabled" value="${param.mobileId}" ></td>
                </tr>
                <input type="hidden"value="${param.mobileId}" name="mobileId" >
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
                    <td>Description<input type="text" value="${param.description}" name="description" ></td>
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
                    <td>Price<input type="text" value="${param.price}" name="price"></td>
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
                <tr>
                    <td>Mobile Name<input type="text" disabled="disabled" value="${param.mobileName}" name="mobileName" ></td>
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
                <input type="hidden"value="${param.mobileName}" name="mobileName" >
                <tr>
                    <td>Year Of Production<input type="text" value="${param.yearOfProduction}" name="yearOfProduction" ></td>
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
                    <td>Quantity<input type="text" value="${param.quantity}" name="quantity" ></td>
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
                    <td>Not Sale<input type="checkbox" name="notSale" 
                                       <c:if test="${param.notSale}">
                                           checked="checked"
                                       </c:if>
                                       ></td>
                </tr>
                <input type="hidden" name="SearchValue" value="${param.SearchValue}">
                <input type="hidden" name="filter" value="${param.filter}">
                <c:if test="${empty filter}">
                    <input type="hidden" name="filter" value="${requestScope.id}">
                    <c:if test="${empty filter}">
                        <input type="hidden" name="filter" value="${requestScope.name}">
                    </c:if>
                </c:if>
                <tr>
                    <td><input type="submit" name="btnAction" value="submit_Update"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
