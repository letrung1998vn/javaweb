<%-- 
    Document   : search
    Created on : Jun 4, 2018, 9:21:36 AM
    Author     : letru
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <%-- <%
             Cookie[] cookie = request.getCookies();
             if (cookie != null) {
                 out.println(cookie[cookie.length - 1].getName());
             } else {
         %>
         <font color="red">  Welcome ${sessionScope.USERNAME}</font>
         <% }
             String searchValue = request.getParameter("txtSearchValue");
         %>
         <div>
             <form action="Dispatcher">
                 Search value <input type="text" name="txtSearchValue" value="${requestScope.txtSearchValue}" >
                 <%
 //                    if (searchValue == null) {
                                     %>
                 <!--value=""-->
                 <%
                     //                                    } else {
                                                         %>
                 <!--//                                    value="<%=searchValue%>"-->
                 <%
 //                    }
                 %>
                 <!-->--> 
                 <input type="submit" value="Search" name="btnAction" />
             </form>
         </div>

        <%            if (searchValue != null) {
                if (!searchValue.isEmpty()) {
                    List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                    if (result != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                        String urlRewriting = "Dispatcher?"
                                + "btnAction=delete"
                                + "&userName="
                                + dto.getUserName()
                                + "&lastSearchValue="
                                + searchValue;
                %>
            <form action="Dispatcher" method="POST">
                <tr>
                    <td>
                        <%=++count%>
                    </td>
                    <td>
                        <%=dto.getUserName()%>
                        <input type="hidden" name="txtUserName" value="<%=dto.getUserName()%>"/>
                    </td>
                    <td>
                        <%=dto.getPassword()%>
                        <input type="hidden" name="txtPassWord" value="<%= dto.getPassword()%>"/>
                    </td>
                    <td>
                        <%=dto.getLastName()%>
                        <input type="hidden" name="txtLastName" value="<%=dto.getLastName()%>"/>
                    </td>
                    <td>
                        <%=dto.isIsAdmin()%>
                    </td>
                <input type="hidden" name="chkRole" 
                       <%
                           if (dto.isIsAdmin()) {
                       %>
                       value="ADMIN"
                       <%
                           }
                       %>
                       />
                <td>
                    <a href="<%=urlRewriting%>">Delete</a>
                </td>
                <td>
                    <input type="hidden" name="lastSearchValue" value="${requestScope.txtSearchValue}"/>
                    <input type="submit" value="Update" name="btnAction" />
                </td>
                </tr>
            </form>

            <%
                }
            %>
        </tbody>
    </table>

    <%        } else {
    %>
    <h1>No record is matched</h1>
    <%     }
            }//and if search Value is not null
        }//if search Value not null
    %>--%>
        <h1>
            Search Book
        </h1>
        <form action="search.jsp">
            Search Value<input type="text" name="txtSearchValue" value="${param.txtSearchValue}"><br>
            <input type="submit" value="Search">
        </form><br>
        <c:set var="SearchValue" value="${param.txtSearchValue}"></c:set>
        <c:if test="${not empty SearchValue}">
            <sql:setDataSource var="con" dataSource="Util"></sql:setDataSource>
            <c:if test="${not empty con}">
                <sql:query var="rs" dataSource="${con}" >
                    Select * from Registration where Lastname like ?
                    <sql:param value="%${SearchValue}%"></sql:param>
                </sql:query>
                <c:if test="${rs.rowCount gt 0}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                    <c:forEach var="colName" items="${rs.columnNames}">
                                    <th>${colName}</th>
                                    </c:forEach>                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="row" items="${rs.rowsByIndex}" varStatus="counter">
                            <td>${counter.count}</td>
                            <c:forEach var="col" items="${row}">
                                <td>${col}</td>
                            </c:forEach>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${rs.rowCount eq 0}">
                <h1>No record is match</h1>
            </c:if>
        </c:if>
    </c:if>
</body>
</html>
