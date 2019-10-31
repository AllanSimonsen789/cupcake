<%-- 
    Document   : shop
    Created on : 27-10-2019, 22:40:31
    Author     : allan
--%>

<%@page import="model.OrderLine"%>
<%@page import="model.Top"%>
<%@page import="model.Bottom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Account account = (Account) session.getAttribute("account");%>
<% ArrayList<Bottom> bottoms = (ArrayList<Bottom>) request.getAttribute("bottoms");%>
<% ArrayList<Top> tops = (ArrayList<Top>) request.getAttribute("tops");%>
<% ArrayList<OrderLine> orderlines = (ArrayList<OrderLine>) session.getAttribute("shoppingcart");%>
<!DOCTYPE html>
<html>
    <head>
        <%%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cupcakes</title>
    </head>
    <body>
        <h1>CUPCAKE SHOP!</h1>
        <h2>Welcome <%=account.getName()%></h2>
        <form name="logout" action="FrontController" method="POST">
            <input type ="hidden" name="command" value="logout">
            <input type="submit" value="Log Out" />
        </form><br>
        <form name="CustomerPage" action="FrontController">
            <input type="hidden" value="CustomerPage"  name="command"/>
            <input type="submit" value="My Profile"  name="profile"/>
        </form>
        <h3>Your balance: <%= account.getBalance()%></h3>
        <form name="shoppingCart" action="FrontController" method="POST">
            <input type="hidden" value="shoppingCart" name="command" />
            <input type="submit" value="Shopping Cart" name="shoppingcart" />
        </form>
        <br>
        <h3> Your cart: <% if (orderlines != null) {
                out.print(orderlines.size());
            } %></h3>
        <form name="addproduct" action="FrontController" method="POST">
            <input type="hidden" value="addproduct" name="command" />
            <div>
                <table style="float: left">
                    <tr>
                        <th>Bottom</th>
                        <th>$</th>
                        <th>Choose</th>
                    </tr>
                    <% for (Bottom bottom : bottoms) {%>
                    <tr>      
                        <td><%=bottom.getName()%></td>
                        <td><%=bottom.getPrice()%></td>
                        <td><input type="radio" name="bottom" value="<%=bottom.getID()%>" /></td>
                    </tr>
                    <% }%>

                </table>
                <table style="float: left">
                    <tr>
                        <th>Top</th>
                        <th>$</th>
                        <th>Choose</th>
                    </tr>
                    <% for (Top top : tops) {%>
                    <tr>      
                        <td><%=top.getName()%></td>
                        <td><%=top.getPrice()%></td>
                        <td><input type="radio" name="top" value="<%=top.getID()%>" /></td>
                    </tr>
                    <% }%>
                </table>
            </div>
            <input type="number" name="qty" value="" placeholder="quantity" min="1" max="100" />
            <input type="submit" value="Put in cart" />
        </form>
    </body>
</html>
