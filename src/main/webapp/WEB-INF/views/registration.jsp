<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Registration</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <form:form class="form-horizontal" modelAttribute="user"
                       action="/registration" method="POST">
                <div class="form-group">
                    <label for="name" class="control-label col-sm-2">Name:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="name" id="name" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="surname" class="control-label col-sm-2">Surname:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="surname" id="surname" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="control-label col-sm-2">E-mail:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="email" id="email" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneNumber" class="control-label col-sm-2">Phone number:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="phoneNumber" id="phoneNumber" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label col-sm-2">Password:</label>
                    <div class="col-sm-10">
                        <form:password path="password" id="password" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                        <%--<div class="col-sm-10 col-sm-offset-2"><form:errors path="checkPassword"/></div>--%>
                    <label for="repeatPassword" class="control-label col-sm-2">Repeat password:</label>
                    <div class="col-sm-10">
                        <form:password path="repeatPassword" id="repeatPassword" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button class="btn btn-success" type="submit">Register</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>