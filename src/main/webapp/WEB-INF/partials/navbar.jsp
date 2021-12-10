    <div class="container">
        <nav class="navbar navbar-expand-sm navbar-light bg-light">
            <div class="navbar-header">
                <a class="navbar-brand" href="/cars">Carlister</a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active pl-2"><a href="/register">Register</a></li>
                    <li class="nav-item pl-2">
                        <a href="/login">Login</a>
                    </li>
                    <li class="nav-item pl-2">
                        <a href="/logout">Logout</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="/search" method="post">
                    <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>

