<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://kit.fontawesome.com/f9e982cf9d.js" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Name</title>
</head>
<body style="background-color: #dddddd">
<%@include file="template/navbar.jsp" %>









<div class="row">
    <div class="col-lg-9"></div>
    <div class="col-lg-3">
        <div>
            <div>
                ${id}
                ${chat}
                    ${chatId}
                <form:form class="form-horizontal"
                           action="/chats/${chatId}/${id}/message" method="POST">
                    <input type="text" name="message"  placeholder="Message"/>
<%--                    <input type="text" name="chatId" />--%>
<%--                    <input type="hidden" path="Id" value="${chat.id}"/>--%>


                    <button type="submit" class="btn btn-info" style="background-color: #04B4AE; color: white">
                        Sent
                    </button>

                </form:form>
            </div>
        </div>
    </div>
</div>


<div>
    <ul class="list-group">
        <c:forEach var="message" items="${messages}">
            <div class="container mt-3">

                <li class="list-group-item">
                    ${message.text}, ${message.date}, ${message.ownerId}, ${message.ownerName},
                            ${message.recipientId},${message.chatId}
                </li>

            </div>
        </c:forEach>
    </ul>
</div>



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