<%-- 
    Document   : shoppingCart
    Created on : Oct 30, 2019, 9:32:37 AM
    Author     : THOMA
--%>

<%@page import="model.OrderLine"%>
<%@page import="model.Top"%>
<%@page import="model.Bottom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Account account = (Account) session.getAttribute("account");%>
<% ArrayList<OrderLine> orderlines = (ArrayList<OrderLine>) session.getAttribute("shoppingcart");%>
<% ArrayList<Bottom> bottoms = (ArrayList<Bottom>) request.getAttribute("bottoms");%>
<% ArrayList<Top> tops = (ArrayList<Top>) request.getAttribute("tops");%>


<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <h2>Velkommen <%=account.getName()%></h2>
        <h3>Din kurv:</h3>
        <br>
        <table style="float: left">
                        <tr>
                   <% for (OrderLine orderline : orderlines) {%>
                   <tr>      
                            <td><%=orderline.getTopID()%></td>
                            <td><%=orderline.getBottomID()%></td>
                            
                        </tr>
                    
        
    </body>
</html>
