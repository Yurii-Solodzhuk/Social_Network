<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://kit.fontawesome.com/f9e982cf9d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Name</title>
</head>
<body style="background-color: #dddddd">
<%@include file="template/navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <div class="card" style="width: 15rem;">
                <img src="/img/${currentUser.avatarURL}" class="card-img-top" alt="Avatar">
                <div class="card-body" style="background-color: #dddddd">
                    <form:form method="post" action="/upload-avatar" enctype="multipart/form-data">
                        <input type="file" name="avatarURL" id="avatarURL">
                        <button type="submit" class="btn btn-info" style="background-color: #04B4AE; color: white">
                            Upload
                        </button>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-sm-8 col-sm-offset-2">
            <form:form class="form-horizontal" modelAttribute="user"
                       action="/edit-user" method="POST">
                <div class="form-group">
                    <label for="city" class="control-label col-sm-2">City:</label>
                    <div class="col-sm-10">
                        <input type="text" name="city" id="city" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="work" class="control-label col-sm-2">Work:</label>
                    <div class="col-sm-10">
                        <input type="text" name="work" id="work" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="bithday" class="control-label col-sm-2">B-day:</label>
                    <div class="col-sm-10">
                        <input type="text" name="bithday" id="bithday" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="info" class="control-label col-sm-2">About:</label>
                    <div class="col-sm-10">
                        <input type="text" name="info" id="info" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-info" type="submit" style="background-color: #04B4AE">Save</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
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