<%-- 
    Document   : search
    Created on : Jun 29, 2018, 9:39:25 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h3 color="red">
            Welcome, <s:property value="username"/>_
            <s:property value="%{#session.USERNAME}"/>
        </h3>
        <h3 style="color: red">Search page</h3>
        <form action="searchLastname">
            <input type="text" name="searchValue" value="" />
            <input type="submit" value="Search" />
        </form>

        <s:if test="%{!searchValue.isEmpty()}">
            <s:if test="%{listAccounts != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Last name</th>
                            <th>Role</th>
                            <td>Delete</td>
                            <td>Update</td>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listAccounts" status="counter">
                            <s:form action="updatePassRole" theme="simple">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="username"/>
                                    <s:hidden name="username" value="%{username}"/>
                                </td>
                                <td>
                                    <s:textfield name="password" value="%{password}"/>
                                </td>
                                <td>
                                    <s:property value="lastname"/>
                                </td>
                                <td>
                                    <s:checkbox name="chkAdmin" value="%{role}"/>
                                </td>
                                <td>
                                    <s:url id="delLink" action="deleteAccount">
                                        <s:param name="username" value="username"/>
                                        <s:param name="lastSearchValue" value="searchValue"/>
                                    </s:url>
                                    <s:a href="%{delLink}">Delete</s:a>
                                </td>
                                <td>
                                <s:submit value="Update"/>
                                <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                </td>
                            </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <h2>No record is matched</h2>
            </s:else>
        </s:if>
    </body>
</html>
