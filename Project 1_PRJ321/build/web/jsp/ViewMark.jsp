<%-- 
    Document   : Viewcart
    Created on : Jun 27, 2018, 8:15:58 PM
    Author     : letru
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VIew Mark</title>
    </head>
    <body>
        <c:set var="userName" value="${sessionScope.userName}"/>
        <c:set var="firstTime" value="${requestScope.firstTime}"/>
        <c:set var="success" value="${requestScope.success}"/>
        <c:if test="${not empty userName}">
            <div style="width: 100%; height: 100px; margin-top: 50px; margin-left: 2% ">
                <c:if test="${not empty firstTime}">
                    <font color="red">
                    <h3>Welcome ${firstTime} </h3>
                    </font>
                </c:if>
                <c:if test="${not empty success}">
                    <font color="red">
                    <h3>Success FeedBack</h3>
                    </font>
                </c:if>
                <div style="width: 87%; height: 100px; float: left; text-align: right; margin-bottom: -40px; margin-top: -55px " >
                    <p style="margin-right: 80px; margin-bottom: -18px">
                        <font color="red">Student Name:${sessionScope.studentName}</font>
                    </p>
                    <form action="logOut">
                        <button type="submit">Log Out</button>
                    </form>
                </div>
            </div>
            <div style="width: 100%; height: 200px; float: left; margin-left: 2% ">
                <h3>Mark Table</h3>
                <p>Subject's mark details</p>
                <c:set var="marks" value="${requestScope.marks}"/>
                <c:if test="${not empty marks}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Subject Name</th>
                                <th>Block</th>
                                <th>Semester</th>
                                <th>Year</th>
                                <th>Avg</th>
                                <th>Status</th>
                                <th>Action</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <form action="sendFeedBack">
                            <c:set var="pass" value="0"/>
                            <c:set var="GPA" value="0"/>
                            <c:set var="totalcredit" value="0"/>
                            <c:set var="passcredit" value="0"/>
                            <c:set var="credits" value="${requestScope.credits}"/>
                            <c:set value="${requestScope.subjects}" var="subjectName"/>
                            <c:forEach items="${marks}" var="mark" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        <c:forEach items="${subjectName}" var="subject">
                                            <c:if test="${subject.key==mark.subjectID}">
                                                ${subject.value}
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <c:forEach items="${credits}" var="credits">
                                        <c:if test="${credits.key==mark.subjectID}">
                                            <c:set var="credit" value="${credits.value}"/>
                                            <c:set var="totalcredit" value="${totalcredit+credit}"/>
                                        </c:if>
                                    </c:forEach>
                                    <td>${mark.block}</td>
                                    <td>${mark.semester}</td>
                                    <td>
                                        <fmt:formatNumber type="number" maxFractionDigits="0" value="${mark.year}" />
                                    </td>
                                    <td>
                                        <fmt:formatNumber type="number" maxFractionDigits="1" value="${mark.subjectAvg}" />
                                        <c:set var="GPA" value="${GPA+(mark.subjectAvg*credit)}"/>
                                    </td>
                                    <td>
                                        ${mark.status}
                                        <c:if test="${mark.status=='Pass'}">
                                            <c:set var="passcredit" value="${passcredit+credit}"/>
                                        </c:if>
                                        <c:if test="${mark.status=='Improved'}">
                                            <c:set var="passcredit" value="${passcredit+credit}"/>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:url var="addr" value="ViewDetail">
                                            <c:param name="subjectID" value="${mark.subjectID}"/>
                                        </c:url>
                                        <a href="${addr}">View Detail</a>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="subjectID" value="${mark.subjectID}"
                                               <c:if test="${mark.status=='Not_Started'}">
                                                   disabled="disabled"
                                               </c:if>
                                               >
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="4">Pass Credit:${passcredit}</td>

                                <td colspan="3">GPA:
                                    <fmt:formatNumber type="number" maxFractionDigits="1" value="${GPA/totalcredit}" /></td>
                                <td colspan="3">
                                    <button type="submit" style="width: 100%; height: 20px">Send Feedback</button>
                                </td>
                            </tr>
                        </form>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty marks}">
                    <h1>no mark to show</h1>
                </c:if>
            </div>
        </c:if>
        <c:if test="${empty userName}">
            <c:redirect url="Login.html"/>
        </c:if>

    </body>
</html>
