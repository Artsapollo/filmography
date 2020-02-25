<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Password" name="password" required>


        <div>
            <div>
                <td><input type="submit" value="LogIn"></td>

            </div>
            <div>
                <button onclick="location.href='/signUp'">Sign up</button>
            </div>
        </div>

    </div>

</form>
</body>
</html>