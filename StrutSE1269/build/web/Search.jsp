<%-- 
    Document   : Search
    Created on : Jun 25, 2018, 9:33:00 AM
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
        <font color="red">
        Welcome,${sessionScope.LoginStrutsActionForm.userName}
        </font>
        <h1>Search Page</h1>
        <form action="SearchLastName.do">
            Search value<input type="text" name="SearchValue" />
            <input type="submit" value="search">
        </form>
        <c:set var="searchValue" value="${param.SearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${sessionScope.SearchLastNameStrutsActionForm.listAccount}"/>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>User Name</th>
                        <th>Password</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>ACtion</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}">
                        <tr>
                            <td>${dto.userName}</td>
                            <td>${dto.password}</td>
                            <td>${dto.lastName}</td>
                            <td>${dto.isAdmin}</td>
                        </tr>
                        <c:url var="delete" value="delete.do">
                            <c:param name="userName" value="${dto.userName}"/>
                            <c:param name="searchValue" value="${searchValue}"/>
                        </c:url>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>


    </body>
</html>
