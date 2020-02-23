<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 23.02.2020
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form action="/signUp" method="post">
    <div class="container">
        <h1>Sign Up</h1>

        <p>Please fill in this form to create an account</p>
        <hr>

        <label for="user_name"><b>Login</b></label>
        <input type="text" placeholder="Enter Username" name="user_name" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <div class="clearfix">
            <button onclick="location.href='/main'">Sign up</button>
        </div>
    </div>
</form>
</body>
</html>
