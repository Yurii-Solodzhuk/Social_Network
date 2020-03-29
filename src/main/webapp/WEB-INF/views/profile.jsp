<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
        <a style="color: white" href="#about">About</a>
        <form:form action="/logout" method="post">
            <input type="submit" value="LogOut"/>
        </form:form>
    </div>
</div>

<div class="container">
    <%--    <div class="row">--%>
    <%--        <div class="col-sm-12">--%>
    <%--            <table class="table table-bordered">--%>
    <%--                <tr>--%>
    <%--                    <th>All posts</th>--%>
    <%--                </tr>--%>
    <%--                <c:forEach var="location" items="${locations}">--%>
    <%--                    <tr>--%>
    <%--                        <td><img width="100%" alt="Location image" src="/images/${location.photoUrl}"></td>--%>
    <%--                        <td>${location.name}</td>--%>
    <%--                        <td>--%>
    <%--                            <div class="col-sm-10 col-sm-offset-2">--%>
    <%--                                <a href="/admin/location/${location.id}">--%>
    <%--                                    <button class="btn btn-success" type="submit">Edit</button>--%>
    <%--                                </a>--%>
    <%--                            </div>--%>
    <%--                        </td>--%>

    <%--                        <td>--%>
    <%--                            <div class="col-sm-10 col-sm-offset-2">--%>
    <%--                                <a href="/admin/location/delete/${location.id}">--%>
    <%--                                    <button class="btn btn-danger" type="submit">Delete</button>--%>
    <%--                                </a>--%>
    <%--                            </div>--%>
    <%--                        </td>--%>
    <%--                    </tr>--%>
    <%--                </c:forEach>--%>
    <%--            </table>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%--    <div class="row">--%>
    <%--        <div class="col-sm-8 col-sm-offset-2">--%>
    <%--            <form:form class="form-horizontal"--%>
    <%--                       action="/addLocation" method="POST" enctype="multipart/form-data">--%>
    <%--                <div class="form-group">--%>
    <%--                    <label for="locationName" class="control-label col-sm-2">Location name:</label>--%>
    <%--                    <div class="col-sm-10">--%>
    <%--                        <input type="text" name="locationName" id="locationName" class="form-control" />--%>
    <%--                    </div>--%>

    <%--                </div>--%>
    <%--                <div class="form-group">--%>
    <%--                    <label for="file" class="control-label col-sm-2">Select img:</label>--%>
    <%--                    <div class="col-sm-10">--%>
    <%--                        <input name="image" id="image" type="file">--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--                <div class="form-group">--%>
    <%--                    <div class="col-sm-10 col-sm-offset-2">--%>
    <%--                        <button class="btn btn-success" type="submit">add Location</button>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </form:form>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <b>User info</b>
    <div>
        userName: <b>${user.name}</b> surname: <b>${user.surname}</b> phone: <b>${user.phoneNumber}</b>
    </div>

    <div>
        <img alt="Avatar" src="/img/${user.avatarURL}">
    </div>


        <div>
            <form method="post" action="/upload" enctype="multipart/form-data">
                <input type="file" name="file" id="file">
                <button type="submit">Upload</button>
            </form>
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