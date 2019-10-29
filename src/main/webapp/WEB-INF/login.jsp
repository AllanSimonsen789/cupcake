<%-- 
    Document   : login
    Created on : Oct 29, 2019, 3:50:45 PM
    Author     : Malthe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <table>
            <tr><td>Please insert info: </td>
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
            </tr>
        </table>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<H2>" + error + "</h2>");
            }
        %>
    </body>
</html>
