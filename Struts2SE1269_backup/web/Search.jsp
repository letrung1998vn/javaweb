<%-- 
    Document   : Search
    Created on : Jun 29, 2018, 9:40:31 AM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, <s:property value="userName"/>
        Welcome, <s:property value="%{#session.USERNAME}"/>
        </font>
        <h1>Search Page</h1>
        <form action="SearchLastName" method="POST">
            Search Value<input type="text" name="SearchValue" value="" />
            <input type="submit" value="search">
        </form><br>

        <s:if test="%{!SearchValue.isEmpty()}">
            <s:if test="%{listAccount!=null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>UserName</th>
                            <th>PassWord</th>
                            <th>Last Name</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listAccount" status="counter">
                            <s:form action="UpdateAccount" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="userName"/>
                                        <s:hidden name="userName" value="%{userName}"/>
                                    </td>
                                    <td> 
                                        <s:textfield name="password" value="%{password}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="lastName" value="%{lastName}"/>
                                    </td>
                                    <td> 
                                        <s:checkbox name="isAdmin" value="%{isAdmin}"/>
                                    </td>
                                    <td>
                                        <s:url id="delete" action="DeleteAccount">
                                            <s:param name="userName" value="userName"/>
                                            <s:param name="LastSearchValue" value="SearchValue"/>
                                        </s:url>
                                        <s:a href="%{delete}">Delete</s:a><%--Tat ca cac control bat buoc dinh tri --%>
                                        </td>
                                        <td>                                   
                                        <s:submit value="Update"/>
                                        <s:hidden name="lastSearchValue" value="searchValue"/>  
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:else>
                <h2>No record is matched!!!</h2>
            </s:else>
        </s:if>
    </body>
</html>
