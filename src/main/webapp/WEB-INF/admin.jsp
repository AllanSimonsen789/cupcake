<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : admin
    Created on : 27-10-2019, 22:40:50
    Author     : allan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Invoice"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADMIN</h1><br>
        <form name="logout" action="FrontController" method="POST">
            <input type ="hidden" name="command" value="logout">
            <input type="submit" value="Log Out" />
        </form>
        <h2>Customer List</h2>
        <table>
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Role</th>
                <th>Balance</th>
                <th>Add Funds</th>
            </tr>
            <c:forEach var="account" items="${requestScope.customers}">
                <tr>
                    <td>
                        <c:out value="${account.getID()}" />
                    </td>
                    <td>
                        <c:out value="${account.getName()}" />
                    </td>
                    <td>
                        <c:out value="${account.getPhone()}" />
                    </td>
                    <td>
                        <c:out value="${account.getEmail()}" />
                    </td>
                    <td>
                        <c:out value="${account.getRole()}" />
                    </td>
                    <td>
                        <c:out value="${account.getBalance()}" />
                    </td>
                    <td>
                        <form name="addFunds" action="FrontController" method="POST">
                            <input type = "hidden" name="command" value="addfunds">
                            <input type="hidden" name="accountid" value="${account.getID()}">
                            <input type="number" name="funds" value="0" placeholder="funds" min="1" max="1000">
                            <input type="submit" value="Add Funds" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table><br>
        <h2>Ordreliste</h2>
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
            <form name="showOrder" action="FrontController" method="POST">
                <input type = "hidden" name="command" value = "showOrder">
                <input type = "hidden" name="invoiceid" value = "<%=invoice.getID()%>">
                <td><input type="submit" value="Invoice" /></td>
            </form>
        </tr>
        <% }%>
    </table>
    <c-rt:set var="invoiceid" value="${requestScope.invoiceid}" scope="request" />
    <c:if test="${not empty invoiceid}">
        <c:set var="invoice" value="${requestScope.invoices[invoiceid-1]}" scope="request" />
        <c:set var="customer" value="${requestScope.customers[invoice.getCustomerID()-2]}" scope="request" />
        <c:set var="bottoms" value="${requestScope.bottoms}" scope="request" />
        <c:set var="tops" value="${requestScope.tops}" scope="request" />

        
        <h2>Invoice: #<c:out value='${invoice.getID()}' /></h2>
        <h3>Total Price: $<c:out value='${invoice.getPrice()}' /></h3>
        <h3>Order Time: <c:out value='${invoice.getTime().toString()}' /></h3>
        <h3>Customer ID: #<c:out value='${customer.getID()}' /></h3>
        <h3>Customer Name: <c:out value='${customer.getName()}' /></h3>
        <h3>Customer Phone: +45<c:out value='${customer.getPhone()}' /></h3>
        <h3>Customer Email: <c:out value='${customer.getEmail()}' /></h3>
        <table>
            <tr>
                <th>Bottom</th>
                <th>Top</th>
                <th>Quatity</th>
                <th>price</th>
            </tr>
        <c:forEach var="orderline" items="${invoice.getOrderlines()}">
                <tr>
                    <td>
                        <c:out value="${bottoms[orderline.getBottomID() - 1].getName()}" />
                    </td>
                    <td>
                        <c:out value="${tops[orderline.getTopID() - 1].getName()}" />
                    </td>
                    <td>
                        <c:out value="${orderline.getQty()}" />
                    </td>
                    <td>
                        <c:out value="${(bottoms[orderline.getBottomID() - 1].getPrice() + tops[orderline.getTopID() - 1].getPrice())*orderline.getQty()}" />
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <h2>
</body>
</html>
