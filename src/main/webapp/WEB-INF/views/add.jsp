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
