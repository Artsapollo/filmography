<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Films</title>
</head>
<body>
<h1>Films catalog</h1>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>action</th>
    </tr>
    <c:forEach var="films" items="${films}">
        <tr>
            <td>${films.id}</td>
            <td>${films.title}</td>
            <td>${films.year}</td>
            <td>${films.genre}</td>
            <td>${films.watched}</td>
            <td>
                <a href="<c:url value="/edit?id=${films.id}"/>">Edit</a>
                <form action="/deletingServlet?id=${films.id}" method="post">
                    <input type="submit" name="button1" value="delete"/>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

<div>
    <div>
        <button onclick="location.href='/servlet/add'">Add new film</button>
    </div>
    <div>
        <button onclick="location.href='/main'">Main page</button>
    </div>
</div>

</body>
</html>
