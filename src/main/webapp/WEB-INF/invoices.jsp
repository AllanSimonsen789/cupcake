<%-- 
    Document   : invoices
    Created on : Oct 30, 2019, 2:18:10 PM
    Author     : Malthe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice</title>
    </head>
    <body>
        <h1>Invoice</h1>
        <div>
            <table style="float: left">
                <thead>
                    <th>#ID</th>
                    <th>Name</th>
                    <th>Bottom</th>
                    <th>Top</th>
                    <th>Quantity</th>
                    <th>Ordered</th>
                    <th>Price</th>
                    <%
                        
                    %>
                    <tr>
            </table>
        </div>
    </body>
</html>
