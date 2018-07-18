<%-- 
    Document   : ViewDetail
    Created on : Jun 29, 2018, 5:30:15 PM
    Author     : letru
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Detail</title>
    </head>
    <body>
        <c:set var="userName" value="${sessionScope.userName}"/>
        <c:if test="${not empty userName}">
            <div style="width: 100%; height: 100px; margin-top: 50px; margin-left: 2% ">
                <h1>Subject Mark Detail</h1>
                <div style="width: 87%; height: 100px; float: left; text-align: right; margin-bottom: -40px; margin-top: -55px " >
                    <p style="margin-right: 80px; margin-bottom: -18px">
                        <font color="red">Student Name:${sessionScope.studentName}</font>
                    </p>
                    <form action="logOut">
                        <button type="submit">Log Out</button>
                    </form>
                </div>
            </div>
            <div style="width: 100%; height: 500px; float: left; margin-left: 2% ">
                <h1>Subject Name: ${requestScope.subjectName}</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Subject Name</th>
                            <th>Block</th>
                            <th>Semester</th>
                            <th>Year</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="marks" value="${requestScope.marks}"/>
                        <c:forEach items="${marks}" var="mark" varStatus="counter">
                            <c:set var="size" value="${counter.count}"/>
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${requestScope.subjectName}
                                </td>
                                <td>
                                    ${mark.block}
                                </td>
                                <td>
                                    ${mark.semester}
                                </td>
                                <td>
                                    <fmt:formatNumber type="number" maxFractionDigits="0" value="${mark.year}" />
                                </td>
                                <td>
                                    ${mark.status}
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="5">
                                Number of studying: ${size}
                            </td>
                        </tr>
                    </tbody>
                </table>
                <form action="backViewMark" method="post">
                    <button type="submit" style="width: 100px; height: 35px">Back To View Mark Table</button>
                </form>
            </div>
        </c:if>
         <c:if test="${empty userName}">
            <c:redirect url="Login.html"/>
        </c:if>
    </body>
</html>
