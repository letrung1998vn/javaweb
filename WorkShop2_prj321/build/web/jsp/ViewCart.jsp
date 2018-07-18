<%-- 
    Document   : ViewCart
    Created on : Jun 21, 2018, 11:57:10 PM
    Author     : letru
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Your cart include</h1>
        <s:if test="%{#session.cart!=null}">
            <s:if test="%{#session.cart.item==null}">
                <h1>No thing in your Cart</h1>
                <s:form action="BackSearchPrice">
                    <s:submit value="Back To Search Price"/>
                </s:form>
            </s:if>
            <s:else>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                    <form action="RemoveItemCart">
                        <s:iterator value="%{#session.cart.item}" status="counter">
                            <tr>
                                <td><s:property value="%{#counter.count}"/></td>
                                <td><s:property value="key"/></td>
                                <td><s:property value="value"/></td>
                                <td><input type="checkbox" name="mobileName" value=<s:property value="key"/> ></td>
                            </tr>
                        </s:iterator>
                        <tr>
                            <td colspan="3">                           
                                <input type="submit" value="Remove"/>
                            </td>
                    </form>
                    <td colspan="1">
                        <s:form action="BackSearchPrice">
                            <s:submit value="Back To Search Price"/>
                        </s:form>
                    </td>
                    <td colspan="1">
                        <s:form action="CheckOut">
                            <s:submit value="Check Out"/>
                        </s:form>
                    </td>
                </tr>
            </tbody>
        </table>
    </s:else>
</s:if>
<s:else>
    <h1>No thing in your Cart</h1>
    <s:form action="BackSearchPrice">
        <s:submit value="Back To Search Price"/>
    </s:form>
</s:else>

</body>
</html>
