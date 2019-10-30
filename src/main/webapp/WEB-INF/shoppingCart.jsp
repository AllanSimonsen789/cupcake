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
<%double totalSum = 0;%>



<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your shopping cart</title>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <h2>Welcome <%=account.getName()%></h2>
        <p>Balance: <%= account.getBalance()%></p>
        <h3>Your shopping cart:</h3>
        <% if (orderlines != null) { %>
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
                for (OrderLine orderline : orderlines) {
                    Bottom bottom = bottoms.get(orderline.getBottomID() - 1);
                    Top top = tops.get(orderline.getTopID() - 1);
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
        <% } else {%>
        <p>Your cart is empty!</p>
        <% }%>
        <form name="ProductPage" action="FrontController" method="POST">
            <input type="hidden" value="ProductPage" name="command" />
            <input type="submit" value="Add Cupcakes" name="productpage" />
        </form><br>
        <form name="ConfirmationPage" action="FrontController" method="POST">
            <input type="hidden" value="ConfirmationPage" name="command" />
            <input type="hidden" value="<%=totalSum%>" name="totalprice" />
            <input type="submit" value="Place Order" name="invoicepage" />
        </form>
    </body>
</html>
