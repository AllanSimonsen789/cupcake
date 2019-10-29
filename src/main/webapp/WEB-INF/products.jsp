<%-- 
    Document   : shop
    Created on : 27-10-2019, 22:40:31
    Author     : allan
--%>

<%@page import="model.Top"%>
<%@page import="model.Bottom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Account account = (Account) session.getAttribute("account");%>
<% ArrayList<Bottom> bottoms = (ArrayList<Bottom>) request.getAttribute("bottoms");%>
<% ArrayList<Top> tops = (ArrayList<Top>) request.getAttribute("tops");%>
<!DOCTYPE html>
<html>
    <head>
        <%%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CUPCAKE SHOP!</h1>
        <h2>Velkommen <%=account.getName()%></h2>
        <h3>Din Balance er: <%= account.getBalance()%></h3>

        <div>
            <form>
                <table style="float: left">
                    <tr>
                        <th>Bund</th>
                        <th>Pris</th>
                        <th>Vælg</th>
                    </tr>
                    <% for (Bottom bottom : bottoms) {%>
                    <tr>      
                        <td><%=bottom.getName()%></td>
                        <td><%=bottom.getPrice()%></td>
                        <td><input type="radio" name="bottom" value="<%=bottom.getID()%>" /></td>
                    </tr>
                    <% } %>

                </table>
                <table style="float: left">
                    <tr>
                        <th>Top</th>
                        <th>Pris</th>
                        <th>Vælg</th>
                    </tr>
                    <% for (Top top : tops) {%>
                    <tr>      
                        <td><%=top.getName()%></td>
                        <td><%=top.getPrice()%></td>
                        <td><input type="radio" name="top" value="<%=top.getID%>" /></td>
                    </tr>
                    <% }%>
                </table>
            </form>
        </div>
    </body>
</html>
