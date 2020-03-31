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
    <title>Name</title>
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

<div class="container">

    <b>User info</b>
    <div>
        userName: <b>${user.name}</b> surname: <b>${user.surname}</b> phone: <b>${user.phoneNumber}</b>
    </div>

    <div>
        <img alt="Avatar" src="/img/${user.avatarURL}">
    </div>


        <div>
            <form method="post" action="/upload" enctype="multipart/form-data">
                <input type="file" name="avatarURL" id="avatarURL" >
                <input type="submit" value="Upload" />
            </form>
        </div>

    <c:if test="${!isCurrentUser}">
        <c:if test="${isSubcriber}">
            <a class="btn btn-info" href="/unsubscribe/${user.id}">Unsubscribe</a>
        </c:if>
            <a class="btn btn-info" href="/subscribe/${user.id}">Subscribe</a>
    </c:if>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Subscriptions</div>
                        <h3 class="card-text">
                            <a href="/subscriptions/${user.id}/list">${subscriptionsCount}</a>
                        </h3>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Subscribers</div>
                        <h3 class="card-text">
                            <a href="/subscribers/${user.id}/list">${subscribersCount}</a>

                        </h3>
                    </div>
                </div>
            </div>
        </div>
    </div>











    <b>Posts:</b>
    <div>
        <div>

            <form:form class="form-horizontal" modelAttribute="post"
                       action="/post" method="POST">
                <form:input type="text" path="text" placeholder="Message"/>
                <form:input type="hidden" path="recipientId" value="${user.id}"/>


                <button type="submit">Submit</button>
            </form:form>
        </div>

        <%--        <div>--%>

        <%--            <form enctype="multipart/form-data" action="/test" method="POST">--%>
        <%--                <input type="file" path="file" name="file" />--%>


        <%--                <button type="submit">Test</button>--%>
        <%--            </form>--%>
        <%--        </div>--%>


        <div><strong>All posts</strong></div>
        <c:forEach var="post" items="${posts}">
            author: <a href="/${post.author.id}"><b>${post.author.name}</b></a> surname:
            <b>${post.author.surname}</b> post: <b>${post.text}</b> <br/>
        </c:forEach>
    </div>

</div>

</body>
</html>