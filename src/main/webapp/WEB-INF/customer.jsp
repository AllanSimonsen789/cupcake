<%-- 
    Document   : customer
    Created on : Oct 28, 2019, 10:34:40 PM
    Author     : Malthe
--%>

<%@page import="model.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Account account = (Account) session.getAttribute("account");%>
<% ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
    </head>
    <body>
        <h1>Profile page</h1>
        <form name="logout" action="FrontController" method="POST">
            <input type ="hidden" name="command" value="logout">
            <input type="submit" value="Log Out" />
        </form><br>
        <form name="ProductPage" action="FrontController" method="POST">
            <input type="hidden" value="ProductPage" name="command" />
            <input type="submit" value="Go back to shop" name="productpage" />
        </form><br>
        <h2>Name: <%=account.getName()%></h2>
        <h3>Email: <%=account.getEmail()%></h3>
        <h3>Phone: +45<%=account.getPhone()%></h3>
        <h3>Balance: <%=account.getBalance()%></h3>
        <table>
            <tr>
                <th>Invoice ID</th>
                <th>Customer ID</th>
                <th>Price</th>
                <th>Order Time</th>
                <th>Invoice</th>
            </tr>
            <% for (Invoice invoice : invoices) {%>
            <tr>      
                <td><%=invoice.getID()%></td>
                <td><%=invoice.getCustomerID()%></td>
                <td><%=invoice.getPrice()%></td>
                <td><%=invoice.getTime()%></td>
            <form name="InvoicePage" action="FrontController" method="POST">
                <input type = "hidden" name="command" value = "InvoicePage">
                <input type = "hidden" name="invoiceid" value = "<%=invoice.getID()%>">
                <td><input type="submit" value="Invoice" /></td>
            </form>
        </tr>
        <% }%>
    </table>
</body>
</html>
