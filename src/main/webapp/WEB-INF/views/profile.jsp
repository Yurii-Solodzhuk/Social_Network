<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Name</title>
</head>
<body style="background-color: #dddddd">
<%@include file="template/navbar.jsp" %>

<div class="container mt-5">
    <div class="row">
        <div class="col-lg-4">


            <div class="card" style="width: 15rem;">
                <img src="/img/${user.avatarURL}" class="card-img-top" alt="Avatar">
                <c:if test="${isCurrentUser}">
                    <div class="card-body" style="background-color: #dddddd">
                        <form:form method="post" action="/upload-avatar" enctype="multipart/form-data">
                            <input class="mr-1" type="file" name="avatarURL" id="avatarURL" style="width: 120px">
                            <button type="submit" class="btn btn-info" style="background-color: #04B4AE; color: white">
                                Upload
                            </button>
                        </form:form>
                    </div>
                </c:if>
            </div>
        </div>
        <div class="col-lg">
            <b style="font-size: 30px">${user.name} ${user.surname}</b>
            <div class="row mt-2">
                <div class="col-1">
                    <c:if test="${!isCurrentUser}">
                        <a class="btn btn-info" href="#">Message</a>
                    </c:if>
                </div>
                <div class="col-1 ml-5">
                    <c:if test="${!isCurrentUser}">
                        <c:if test="${isSubcriber}">
                            <a class="btn btn-info" href="/unsubscribe/${user.id}">Unsubscribe</a>
                        </c:if>
                        <c:if test="${!isSubcriber}">
                            <a class="btn btn-info" href="/subscribe/${user.id}">Subscribe</a>
                        </c:if>
                    </c:if>
                </div>
            </div>
            <div class="container  mt-4">
                <div class="row">
                    <b>User info</b>
                    <div>
                        phone: <b>${user.phoneNumber}</b>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="container my-3">
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


                <button type="submit" class="btn btn-info" style="background-color: #04B4AE; color: white">Sent</button>
            </form:form>
        </div>

        <div><strong>All posts</strong></div>
        <div>
            <ul class="list-group">
                <c:forEach var="post" items="${posts}">
                    <div class="container mt-3">
                        <li class="list-group-item">
                            <a href="/${post.author.id}"><b><img src="/img/${post.author.avatarURL}"
                                                                 class="rounded-circle z-depth-0"
                                                                 alt="avatar image" height="40px"
                                                                 width="40px"> ${post.author.name} ${post.author.surname}
                            </b></a><br>
                            <b>${post.text}</b> <br/>
                        </li>
                    </div>
                </c:forEach>
            </ul>
        </div>
    </div>

</div>

<%@include file="template/footer.jsp" %>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>