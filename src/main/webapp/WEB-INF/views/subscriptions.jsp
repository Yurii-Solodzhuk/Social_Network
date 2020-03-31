<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Subscriptions</title>
</head>
<body>
<div style=" background-color: #333; overflow: hidden;" class="topnav">
    <div style="float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px ;background-color: #ddd;
    color: black;    background-color: #4CAF50;">
        <a style="color: white" class="active" href="/">Home</a>
        <a style="color: white" href="#news">News</a>
        <a style="color: white" href="#contact">Contact</a>
        <a style="color: white" href="/admin">ADMIN</a>
        <form:form action="/logout" method="post">
            <input type="submit" value="LogOut"/>
        </form:form>
    </div>
</div>

<h3>${user.name} ${user.surname}</h3>

<div>${type}</div>

<div>
    <ul class="list-group">
        <c:forEach var="subscriber" items="${subscriptions}">
            <li class="list-group-item">
                <a href="/${subscriber.id}">${subscriber.name} ${subscriber.surname}</a>
            </li>
        </c:forEach>
    </ul>
</div>


</body>
</html>