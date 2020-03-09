<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Login</title>
</head>
<body style="background-color: #dddddd">
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8"></div>
        <div class="col-sm-4">
            <h1 style="text-align: center; color: #04B4AE">Login to continue</h1>
            <form:form class="form-horizontal" action="/login" method="POST">
                <div class="form-group">
                    <label for="email" class="control-label col-sm-2" style="color: #04B4AE">Email:</label>
                    <div class="col-sm-10">
                        <input type="text" name="email" id="email" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label col-sm-2" style="color: #04B4AE">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" id="password" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="rememberMe">
                            <label class="custom-control-label" for="rememberMe">Remember Me</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button style="background-color: #04B4AE; color: white" class="btn" type="submit">Sing in</button>
                    </div>
                </div>
            </form:form>
            <a href="/registration"  style="color: #04B4AE">Registration</a>
        </div>
    </div>
</div>
</body>
</html>