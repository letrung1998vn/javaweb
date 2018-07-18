<%-- 
    Document   : SendFeedBack
    Created on : Jun 30, 2018, 3:41:52 PM
    Author     : letru
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send FeedBack</title>
    </head>
    <body>
        <c:set var="userName" value="${sessionScope.userName}"/>
        <c:if test="${not empty userName}">
            <div style="width: 100%; height: 100px; margin-top: 50px; margin-left: 2% ">
                <h1>Student ID:${userName}</h1>
                <div style="width: 87%; height: 100px; float: left; text-align: right; margin-bottom: -40px; margin-top: -65px " >
                    <p style="margin-right: 80px; margin-bottom: -18px">
                        <font color="red">Student Name:${sessionScope.studentName}</font>
                    </p>
                    <form action="logOut">
                        <button type="submit">Log Out</button>
                    </form>
                </div>
            </div>
            <c:set var="marks" value="${sessionScope.marks}"/>
            <c:set value="${sessionScope.subjectName}" var="subjectNames"/>
            <div style="width: 100%; height: 500px; float: left; margin-left: 2% ">
                <h1>Student Name: ${sessionScope.studentName}</h1>
                <c:if test="${not empty marks}">
                    <form action="feedBack">
                        <input type="text" 
                               value="Some marks of courses is not correct. Please, explain them for me"
                               name="Content"
                               size="70px"><br>
                        <c:set var="ContentError" value="${requestScope.error}"/>
                        <c:if test="${not empty ContentError}">
                            ${ContentError}
                        </c:if>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Code</th>
                                    <th>Name</th>
                                    <th>Avg</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${marks}" var="mark" varStatus="counter">
                                    <tr>
                                        <td>${counter.count}</td> 
                                        <td>${mark.subjectID}</td>
                                        <td>
                                            <c:forEach items="${subjectNames}" var="subjectName">
                                                <c:if test="${subjectName.key==mark.subjectID}">
                                                    ${subjectName.value}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <fmt:formatNumber type="number" maxFractionDigits="1" value="${mark.subjectAvg}" />
                                        </td>
                                        <td>${mark.status}</td>
                                        <td>
                                            <input type="checkbox" value="${counter.index}" name="RemoveSubject">
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="5">
                                        <button type="submit" name="Action" value="Send" style="width: 100%">Send</button>                                   
                                    </td>
                                    <td colspan="2">
                                        <button type="submit"  name="Action" value="Remove" style="width: 100%">Remove</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                </c:if>
                <c:if test="${empty marks}">
                    <h1>No thing to feedBack</h1>
                </c:if>
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
