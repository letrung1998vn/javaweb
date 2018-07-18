<%-- 
    Document   : Update
    Created on : Jun 7, 2018, 4:09:56 PM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String userName = request.getParameter("userName");
            String pass = request.getParameter("passWord");
            String LastName=request.getParameter("txtLastName");
            int role;
           if (request.getParameter("chkRole")==null) {
                role = 0;
            } else {
                role = 1;
            }
        %>
        <form action="Dispatcher" method="post">
            <input type="text" name="userName" value="<%=userName%>">
            <input type="hidden" name="txtLastName" value="<%=LastName %>">
            <input type="text" name="passWord" value="<%=pass%>">
            <input type="checkbox" <%
                if (role == 1) {
                   %>
                   checked="checked"><input type="hidden" name="chkRole" value="ADMIN">
            <%
            } else {
            %>
            ><input type="hidden" name="chkRole" value="UNADMIN">
            <%
                }
            %>
            <input type="submit" name="btnAction" value="submit_Update">
        </form>
    </body>
</html>
