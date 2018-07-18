<%-- 
    Document   : ViewCart
    Created on : Jun 11, 2018, 9:07:35 AM
    Author     : letru
--%>

<%@page import="java.util.Map"%>
<%@page import="Cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>Your Cart include</h1>
        <%
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart != null) {
                Map<String, Integer> items = cart.getItem();
                if (items != null) {
        %>
        <form action="Dispatcher">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Quality</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (Map.Entry<String, Integer> item : items.entrySet()) {
                    %>
                    <tr>
                        <td>
                            <%=++count%>
                        </td>
                        <td>
                            <%=item.getKey()%>
                        </td>
                        <td>
                            <%=item.getValue()%>
                        </td>
                        <td>
                            <input type="checkbox"name="chkItem" value="<%=item.getKey()%>">
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td colspan="3">
                            <a href="ShoppingCartOnline.jsp">Add More Book To Your Cart</a>
                        </td>
                        <td>
                            <input type="submit" value="Remove Selected Items" name="btnAction">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <%        } else {
        %>
        <h2>No cart is existed !!!</h2>
        <%
                }
            }//set if cart is null
%>
    </body>
</html>
