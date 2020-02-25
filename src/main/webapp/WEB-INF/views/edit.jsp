<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit page</title>
</head>
<body>
<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${film.id}">

    <label for="title">Title</label>
    <input type="text" name="title" id="title">

    <label for="year">Year</label>
    <input type="text" name="year" id="year">

    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre">

    <label for="watched">Watched</label>
    <input type="text" name="watched" id="watched">

    <input type="submit" value="Edit film">

</form>

<div>
    <div>
        <button onclick="location.href='/main'">Main page</button>
    </div>
</div>
</body>
</html>
