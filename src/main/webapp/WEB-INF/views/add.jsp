<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 17.02.2020
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<div>
    <h1>Add new film</h1>
</div>
<body>
<form action = "/add" method="post">
    <input required type="text" name="title" placeholder="Title">
    <input required type="text" name="year" placeholder="Year">
    <input required type="text" name="genre" placeholder="Genre">
    <input required type="checkbox" name="watched" placeholder="Watched">
    <input type="submit" value="Add">
</form>
</body>
</html>
