<%-- 
    Document   : admin
    Created on : 27-10-2019, 22:40:50
    Author     : allan
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADMIN!</h1>
        <h2><%=((Account)session.getAttribute("account")).getName() %></h2>
    </body>
</html>
