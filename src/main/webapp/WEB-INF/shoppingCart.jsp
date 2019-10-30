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
        <title>Your shopping cart</title>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <h2>Welcome <%=account.getName()%></h2>
        <h3>Balance: <%= account.getBalance()%></h3>
        <h3>Your shopping cart:</h3>
        <br>
        <table style="float: left">
            <tr>
                <th>Bottom</th>
                <th>Top</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <%
                double sum = 0;
                double totalSum = 0;
                for (OrderLine orderline : orderlines) {
                    Bottom bottom = bottoms.get(orderline.getBottomID()-1);
                    Top top = tops.get(orderline.getTopID()-1);
                    sum = ((bottom.getPrice() + top.getPrice()) * orderline.getQty());
                    totalSum = sum + totalSum;
            %>        
            <tr>      
                <td><%=bottoms.get(orderline.getBottomID() - 1).getName()%></td>
                <td><%=tops.get(orderline.getTopID() - 1).getName()%></td>                
                <td><%=orderline.getQty()%></td>
                <td><%=sum%></td>                
            </tr>
            <% }%>            
        </table>
        <h3>Total price: <%=totalSum%></h3>
    </body>
</html>
