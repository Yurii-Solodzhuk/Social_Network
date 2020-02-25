<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello world!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2 class="hello-title">Hello ${userId}!</h2>
<script src="/js/main.js"></script>

<form class="m-5" method="post" action="show/{userId}">
    <div class="row">
        <p>${user.name}</p>
        <p>${user.surname}</p>
    </div>
</form>
</body>
</html>