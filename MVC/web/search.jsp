<%-- 
    Document   : search
    Created on : Jun 4, 2018, 9:21:36 AM
    Author     : letru
--%>

<%@page import="registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
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
        Welcome,${sessionScope.USERNAME}
        </font>
        <form>
            Search value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}">
            <input type="submit" value="Search" name="btnAction" />
        </form>
        <c:set var="SearchValue" value="${param.txtSearchValue}"></c:set>
        <c:if test="${not empty SearchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"></c:set>
            <c:if test="${not empty result}">
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
                        <c:forEach var="DTO" items="${result}" varStatus="counter">
                        <form action="Dispatcher">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${DTO.userName}
                                    <input type="hidden" name="userName" value="${DTO.userName}" >
                                </td>
                                <td>  
                                    ${DTO.password}   
                                    <input type="hidden" name="passWord" value="${DTO.password}" >
                                </td>
                                <td>
                                    ${DTO.lastName}   
                                    <input type="hidden" name="txtLastName" value=" ${DTO.lastName}" >
                                </td>
                                <td>
                                    ${DTO.isAdmin}
                                    <input type="checkbox" name="chkRole" value="ON"
                                           <c:if test="${DTO.isAdmin}">
                                               checked="checked"
                                           </c:if>
                                           >

                                </td>
                                <td>
                                    <c:url var="getlink" value="Dispatcher">
                                        <c:param name="btnAction" value="delete"></c:param>
                                        <c:param name="userName" value="${DTO.userName}"></c:param>
                                        <c:param name="lastSearchValue" value="${param.txtSearchValue}"></c:param>
                                    </c:url>
                                    <a href="${getlink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Update">
                                    <input type="hidden" name="lastSearchValue" value="${param.txtSearchValue}">
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h1>No result is matched</h1>
        </c:if>
    </c:if>

    <%--
    <%
        Cookie[] cookie = request.getCookies();
        if (cookie != null) {
            out.println(cookie[cookie.length - 1].getName());
        } else {
    %>
    <font color="red">  Welcome <%=session.getAttribute("USERNAME")%></font>
    <% }
        String searchValue = request.getParameter("txtSearchValue");
    %>
    <div>
        <form action="Dispatcher">
            Search value <input type="text" name="txtSearchValue" <%
                if (searchValue == null) {
                                %>
                                value=""
                                <%
                                } else {
                                %>
                                value="<%=searchValue%>"
            <%
                }
            %>
            > 
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
                    <th>LastName</th>
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
                    <input type="hidden" name="lastSearchValue" value="<%= searchValue%>"/>
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
</body>
</html>
