<%-- 
    Document   : registration
    Created on : Oct 29, 2019, 3:50:35 PM
    Author     : Malthe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <table>
            <tr><td>Please insert info: </td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Navn:<br>
                        <input type="text" name="name" placeholder="Navn">
                        <br>
                        Telefon:<br>
                        <input type="number" name="phone" placeholder="Telefon nummer" min="00000000" max="99999999">
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
