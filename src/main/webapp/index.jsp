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
        <title>Home</title>
    </head>
    <body>
        <h1>Cupcake project</h1>
        <h2>Group 7:</h2>
        <ul>
            <li>Allan</li>
            <li>Casper</li>
            <li>Malthe</li>
        </ul>
        <h1>Homepage</h1>
        <form name="RegisterPage" action="FrontController" method="POST">
            <input type="hidden" value="RegisterPage" name="command" />
            <input type="submit" value="Register" name="register" />
        </form>
        <br>
        <form name="LoginPage" action="FrontController" method="POST">
            <input type="hidden" value="LoginPage" name="command" />
            <input type="submit" value="Login" name="login" />
        </form>
    </body>
</html>
