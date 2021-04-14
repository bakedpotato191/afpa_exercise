<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() + "/Login" %>">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() + "/Registration" %>">Create Account</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath() + "/Propos" %>">A propos</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>