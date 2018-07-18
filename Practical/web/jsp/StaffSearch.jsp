<%-- 
    Document   : StaffSearch
    Created on : Jul 16, 2018, 9:35:54 AM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Page</h1>
        <s:form action="staffSearch">
            Search Value <s:textfield name="SearchValue" value="%{parameters.SearchValue}"/>
            <s:submit value="Search"/>
        </s:form>
            <s:if test="%{products.size()>0}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>description</th>
                            <th>price</th>
                            <th>releasedDate</th>
                            <th>expiredDate</th>
                            <th>barCode</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="products" status="counter">
                            <tr>
                                <td><s:property value="%{counter.count}"/></td>
                                <td><s:property value="name"/></td>
                                <td><s:property value="id"/></td>
                                <td><s:property value="name"/></td>
                                <td><s:property value="description"/></td>
                                <td><s:property value="price"/></td>
                                <td><s:property value="releasedDate"/></td>
                                <td><s:property value="expiredDate"/></td>
                                <td><s:property value="barCode"/></td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:if test="%{products.size()<=0}">
                <h1>No thing match</h1>
            </s:if>
    </body>
</html>
