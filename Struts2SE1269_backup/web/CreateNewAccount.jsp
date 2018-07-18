<%-- 
    Document   : CreateNewAccount
    Created on : Jun 13, 2018, 8:56:22 AM
    Author     : letru
--%>

<%@page import="sample.registration.RegistrationCreateError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <s:head/>
    </head>
    <body>
        <h1>Create</h1>
        <s:form action="CreateAccount" method="post">
            <s:textfield name="userName" label="UserName"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="confirm" />
            <s:textfield name="fullName" label="fullName"/>
            <s:checkbox name="isAdmin" label="isAdmin" />
            <s:submit value="Create" />
            <s:reset value="reset"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate')>-1}">
            <font>
            <s:property value="userName"/> is existed!!!
            </font>
        </s:if>
        <%--<form action="Dispatcher" method="post">
            <c:set var="error" value="${requestScope.CREATEERROR}"></c:set>
                UserName:<input type="text" name="txtUserName" 
                                value="${param.txtUserName}"><br>
            <c:if test="${not empty error.userNameLengthError}">
                ${error.userNameLengthError}<br>
            </c:if>
            PassWord:<input type="password" name="txtPassword" value=""><br>
            <c:if test="${not empty error.passwordLengthError}">
                ${error.passwordLengthError}<br>
            </c:if>
            Confirm:<input type="password" name="txtConfirm" value=""><br>
            <c:if test="${not empty error.confirmLengthError}">
                ${error.confirmLengthError}<br>
            </c:if>
            Full name:<input type="text" name="txtFullName" 
                             value="${param.txtFullName}"><br>
            <c:if test="${not empty error.fullNameLengthError}">
                ${error.fullNameLengthError}<br>
            </c:if>
             <input type="submit" name="btnAction" value="Create">
        </form>--%>
        <%--
        <%
            RegistrationCreateError errors = (RegistrationCreateError) request.getAttribute("CREATEERROR");
        %>
        <form action="Dispatcher">
            UserName:<input type="text" name="txtUserName" 
                            value="<%=request.getParameter("txtUserName") %>"> <br>
            <%
                if (errors != null) {
                    if (errors.getUserNameLengthError() != null) {
            %>
            
            <h3><%=errors.getUserNameLengthError()%></h3>
            <%
                    }
                }
            %>
            PassWord:<input type="password" name="txtPassword" value=""> <br>
            <%
                if (errors != null) {
                    if (errors.getPasswordLengthError() != null) {
            %>
            <h3> <%=errors.getPasswordLengthError()%></h3>
            <%
                    }
                }
            %>
            Confirm:<input type="password" name="txtConfirm" value=""> <br>
            <%
                if (errors != null) {
                    if (errors.getConfirmLengthError() != null) {
            %>
           <h3><%=errors.getConfirmLengthError()%></h3>
            <%
                    }
                }
            %>
            Full name:<input type="text" name="txtFullName" 
                             value="<%=request.getParameter("txtFullName") %>"><br>
            <%
                if (errors != null) {
                    if (errors.getFullNameLengthError() != null) {
            %>
           <h3><%=errors.getFullNameLengthError()%></h3>
            <%
                    }
                }
            %>
            <input type="submit" name="btnAction" value="Create">
        </form>
            <%
                if (errors != null) {
                    if (errors.getUserNameisExist() != null) {
            %>
            <h3> <%=errors.getUserNameisExist()%></h3>
            <%
                    }
                }
            %> 
        --%>
    </body>
</html>
