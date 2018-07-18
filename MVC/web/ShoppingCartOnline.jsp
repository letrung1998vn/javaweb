<%-- 
    Document   : ShoppingCartOnline
    Created on : Jun 11, 2018, 8:54:37 AM
    Author     : letru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store</title>
    </head>
    <body>
        <h1>Online Book Store</h1>
        <form action="Dispatcher">
            Chose book<select name="cboBook">
                <option>Servlet</option>
                <option>TomCat</option>
                <option>JSP</option>
                <option>aaa</option>
                <option>bbb</option>
                <option>ccc</option>
                <option>ddd</option>
            </select>
            <input type="submit" value="Add to Cart" name="btnAction" />
            <input type="submit" value="View Your Cart" name="btnAction" />
            <input type="reset" value="reset" />
        </form>
    </body>
</html>
