<%-- 
    Document   : index.jsp
    Created on : 27-10-2019, 22:33:22
    Author     : allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cupcake projekt</h1>
        <h2>Gruppe 7:</h2>
        <ul>
            <li>Allan</li>
            <li>Casper</li>
            <li>Malthe</li>
        </ul>
        <h1>Login eller registrer</h1>
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" placeholder="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Navn:<br>
                        <input type="text" name="name" placeholder="Navn">
                        <br>
                        Telefon:<br>
                        <input type="number" name="phone" placeholder="Telefon nummer" min="11111111" max="99999999">
                        <br>
                        Email:<br>
                        <input type="email" name="email" placeholder="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" >
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>" + error + "</h2>");
            }
        %>
    </body>
</html>
