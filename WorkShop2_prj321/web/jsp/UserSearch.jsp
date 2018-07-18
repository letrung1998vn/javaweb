<%-- 
    Document   : UserSearch
    Created on : Jun 19, 2018, 4:38:06 PM
    Author     : letru
--%>

<%@page import="DTO.tbl_MoblieDTO"%>
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
        <form action="SearchPrice">
            Search Value: 
            Min<input type="text" name="priceMin" value=<s:property value="priceMin"/>> 
            Max <input type="text" name="priceMax" value=<s:property value="priceMax"/>>
            <input type="submit" value="Search">
        </form>
        <s:if test="%{#session.mobiles.size()>0}">
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
                    <s:iterator value="%{#session.mobiles}" status="counter" var="mobile">
                    <form action="addCart">
                        <tr>
                            <td>
                                <s:property value="%{#counter.count}"/>
                            </td>
                            <td>
                                <s:property value="mobileId"/>
                            </td>
                            <td>
                                <s:property value="description"/>
                            </td>
                            <td>
                                <s:property value="price"/>
                            </td>
                            <td>
                                <s:property value="mobileName"/>
                                <input type="hidden" name="mobileName" value=<s:property value="mobileName"/>>
                            </td>
                            <td>
                                <s:property value="yearOfProduction"/>
                            </td>
                            <td>
                                <s:if test="%{#session.cart.item!=null}">
                                    <s:iterator value="%{#session.cart.item}" status="counter"> 
                                        <s:if test="%{key.equals(mobileName)}">
                                            <s:set var="add" value="mobileName"/>
                                            <s:property value="%{quantity-value}"/>
                                            <s:set var="quantityLeft" value="%{quantity-value}"/>
                                        </s:if>
                                    </s:iterator>
                                </s:if>
                                <s:if test="%{mobileName!=#add}">
                                    <s:property value="quantity"/>
                                </s:if>
                            </td>
                            <td>
                                <s:property value="notSale"/>
                            </td>
                            <td>
                                <s:set var="priceMin" value="%{priceMin}" scope="session"/>
                                <s:set var="priceMax" value="%{priceMax}" scope="session"/>
                                <input type="submit" value="Add To Cart"
                                       <s:if test="%{notSale==true}">
                                           disabled="disabled"
                                       </s:if>
                                       <s:if test="%{#quantityLeft!=null}">
                                           <s:if test="%{#quantityLeft<=0}">
                                               disabled="disabled"
                                           </s:if>
                                       </s:if>
                                       />
                            </td>                      
                        </tr>
                    </form>
                </s:iterator>
                <tr>
                    <td>
                        <s:form action="ViewCart">
                            <s:set var="priceMin" value="%{priceMin}" scope="session"/>
                            <s:set var="priceMax" value="%{priceMax}" scope="session"/>
                            <s:submit value="View Your Cart"/>
                        </s:form>
                    </td>
                </tr>
            </tbody>
        </table>
    </s:if>
    <s:if test="%{#session.mobiles.size()<=0}">
        <h1>No mobile match</h1>
    </s:if>
</body>
</html>
