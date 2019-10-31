<%-- 
    Document   : purchaseConfirmation
    Created on : Oct 30, 2019, 3:32:32 PM
    Author     : Malthe
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="model.Invoice"%>
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
<% ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices");%>
<% int id = (int)request.getAttribute("id"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Confirmation</title>
    </head>
    <body>
        <h1>Thank you for your purchase!</h1>
        <table style="float: left">
            <tr>
                <th>Order ID</th>
                <th>Name</th>
                <th>Bottom</th>
                <th>Top</th>
                <th>Quantity</th>
                <th>Ordered</th>
                <th>Price</th>
            </tr>
            <%
                double sum = 0;
                double totalSum = 0;
                for (OrderLine orderline : orderlines) {
                    Bottom bottom = bottoms.get(orderline.getBottomID() - 1);
                    Top top = tops.get(orderline.getTopID() - 1);
                    sum = ((bottom.getPrice() + top.getPrice()) * orderline.getQty());
                    totalSum = sum + totalSum;
            %>
            <tr>
                <td><%=id %> </td>
                <td><%=account.getName()%> </td>
                <td><%=bottoms.get(orderline.getBottomID() - 1).getName()%> </td>
                <td><%=tops.get(orderline.getTopID() - 1).getName()%></td>
                <td><%=orderline.getQty()%></td>
                <td><%=Timestamp.valueOf(LocalDateTime.now())%></td>
                <td><%=sum%></td>
            </tr>
            <% }%>
        </table>
        <br>
        <br>
        <br>
        <h2>Total price: <%=totalSum%></h2>
        <form name="ProductPage" action="FrontController" method="POST">
            <input type="hidden" value="ProductPage" name="command" />
            <input type="submit" value="Back to Cupcakes" name="productpage" />
        </form><br>
    </body>
</html>
