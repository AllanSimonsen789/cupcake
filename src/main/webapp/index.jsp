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
        <h1>Cupcake webshop</h1>
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
