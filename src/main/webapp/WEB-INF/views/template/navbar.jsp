<!--Navbar -->


<nav class="mb-1 navbar navbar-expand-lg navbar-dark secondary-color lighten-1" style="background-color: #04B4AE">
    <a class="navbar-brand" href="/">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
            aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/chats">My messages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/photos">My photos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/news">News</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto nav-flex-icons">
            <li class="nav-item avatar dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-55" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <img src="/img/${currentUser.avatarURL}" class="rounded-circle z-depth-0"
                         alt="avatar image" height="40px" width="40px">
                </a>
                <div class="dropdown-menu dropdown-menu-lg-right dropdown-secondary"
                     aria-labelledby="navbarDropdownMenuLink-55">
                    <c:if test="${isAdmin}">
                        <a class="dropdown-item" href="/admin">Admin</a>
                    </c:if>
                    <a class="dropdown-item" href="/edit">Edit Profile</a>
                    <a class="dropdown-item" href="/settings">Settings</a>
                    <div class="dropdown-divider"></div>
                    <form:form action="/logout" method="post">
                        <input type="submit" class="dropdown-item" value="Sing Out"/>
                    </form:form>
                </div>
            </li>
        </ul>
    </div>
</nav>
<!--/.Navbar -->