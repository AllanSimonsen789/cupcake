<%-- 
    Document   : invoices
    Created on : Oct 30, 2019, 2:18:10 PM
    Author     : Malthe
--%>

<%@page import="model.OrderLine"%>
<%@page import="model.Top"%>
<%@page import="model.Bottom"%>
<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Invoice invoice = (Invoice)request.getAttribute("invoice");%>
<% Account account = (Account) session.getAttribute("account");%>
<% ArrayList<Bottom> bottoms = (ArrayList<Bottom>) request.getAttribute("bottoms");%>
<% ArrayList<Top> tops = (ArrayList<Top>) request.getAttribute("tops");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice</title>
    </head>
    <body>
        <h1>Invoice</h1>
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
                for (OrderLine orderline : invoice.getOrderlines()) {
                    Bottom bottom = bottoms.get(orderline.getBottomID() - 1);
                    Top top = tops.get(orderline.getTopID() - 1);
                    sum = ((bottom.getPrice() + top.getPrice()) * orderline.getQty());
                    totalSum = sum + totalSum; 
            %>
            <tr>
                <td><%=orderline.getInvoiceID() %> </td>
                <td><%=account.getName() %> </td>
                <td><%=bottoms.get(orderline.getBottomID() - 1).getName()%> </td>
                <td><%=tops.get(orderline.getTopID() - 1).getName()%></td>
                <td><%=orderline.getQty()%></td>
                <td><%=invoice.getTime() %></td>
                <td><%=sum%></td>
            </tr>
            <% } %>
        </table>
        <br>
        <br>
        <br>
        <h2>Total price: <%=totalSum%></h2>

        <form name="CustomerPage" action="FrontController">
            <input type="hidden" value="CustomerPage"  name="command"/>
            <input type="submit" value="Back to Profile"  name="profile"/>
        </form>
    </body>
</html>
