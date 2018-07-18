<%-- 
    Document   : Search
    Created on : Jun 19, 2018, 3:46:29 PM
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
        Welcome <s:property value="%{#session.USERNAME}"/><br>
        <h1>Search Page</h1>
        <form action="StaffSearch" method="post">    
            <input type="text" name="SearchValue" 
                   <s:if test="%{!SearchValue.isEmpty()}">
                       value="<s:property value="SearchValue"/>"
                   </s:if>
                   >
            ID<input type="radio" name="filter" value="id"
                     <s:if test="%{filter.equals('id')}">
                         checked="checked"
                     </s:if>>
            NAME<input type="radio" name="filter" value="name" 
                       <s:if test="%{filter.equals('name')}">
                           checked="checked"
                       </s:if>>
            <br>
            <input type="submit" name="btnAction" value="Search">
        </form>
        <s:form action="insert">
            <s:submit value="Insert"/>
        </s:form>
        <s:if test="%{mobiles.size()>0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>mobile Id</th>
                        <th>description</th>
                        <th>price</th>
                        <th>mobile Name</th>
                        <th>year Of Production</th>
                        <th>quantity</th>
                        <th>not Sale</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="mobiles" status="counter" var="mobile">  
                        <s:form action="update" theme="simple">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="mobileId"/>
                                    <input type="hidden" name="mobileId" value=<s:property value="mobileId"/>>

                                </td>
                                <td>
                                    <s:property value="description"/>
                                    <input type="hidden" name="description" value=<s:property value="description"/>>
                                </td>
                                <td>
                                    <s:property value="price"/>
                                    <input type="hidden" name="price" value=<s:property value="price"/>>
                                </td>
                                <td>
                                    <s:property value="mobileName"/>
                                    <input type="hidden" name="mobileName" value=<s:property value="mobileName"/>>
                                </td>
                                <td>
                                    <s:property value="yearOfProduction"/>
                                    <input type="hidden" name="yearOfProduction" value=<s:property value="yearOfProduction"/>>
                                </td>
                                <td>
                                    <s:property value="quantity"/>
                                    <input type="hidden" name="quantity" value=<s:property value="quantity"/>>
                                </td>
                                <td>
                                    <s:property value="notSale"/>
                                    <input type="hidden" name="notSale" value=<s:property value="notSale"/>>
                                </td>
                                <td> 
                                    <s:set var="lastSearchValue" value="SearchValue" scope="session"/>
                                    <s:set var="filter" value="filter" scope="session"/>
                                    <input type="submit" value="Update"/>
                                </td>
                            </s:form>
                            <td>
                                <s:form action="delete">
                                    <s:hidden name="mobileId" value="%{mobileId}"/>
                                    <s:submit value="Delete"/>
                                </s:form>
                            </td>
                        </tr>                
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:if test="%{mobiles.size()<=0}">
            <h1>No mobile match</h1>
        </s:if>
    </body>
</html>
