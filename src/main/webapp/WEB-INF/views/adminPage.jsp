<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Admin</title>
</head>
<body style="background-color: #dddddd">
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
<div>
    <table>
        <tr>User List</tr>
            <thead>
            <th>ID</th>
            <th>User</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Role</th>
            </thead>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name} ${user.surname}</td>
                    <td>${user.email}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.role}</td>
                    <td>
                        <form action="/admin" method="post">
                            <input type="hidden" name="userId" value="${user.id}" />
                            <input type="hidden" name="action" value="delete" />
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
    </table>
</div>
</div>
</body>
</html>