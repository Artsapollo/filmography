<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 23.02.2020
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Filmography</title>
</head>

<body>

<div>
    <h1>Welcome to the Filmography</h1>
</div>


<form action="/main" method="post">
    <div class="container">

        <div>
            <p>Log in</p>
        </div>

        <label for="user_name"><b>Username</b></label>
        <input type="text" placeholder="Login" name="user_name" required>

        <label for="password"><b>   Password</b></label>
        <input type="password" placeholder="Password" name="password" required>

        <div>
            <button onclick="location.href='/films'">Log in</button>
            <button onclick="location.href='/signUp'">Sign up</button>
        </div>

    </div>

</form>
</body>
</html>