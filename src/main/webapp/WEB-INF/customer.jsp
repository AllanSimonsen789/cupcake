<%-- 
    Document   : customer
    Created on : Oct 28, 2019, 10:34:40 PM
    Author     : Malthe
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Account account = (Account) session.getAttribute("account");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
    </head>
    <body>
        <h1>Hello <%=account.getName()%>, this is your incredible profile!</h1>
        <h3>Balance: <%= account.getBalance()%></h3>
        
    </body>
</html>
