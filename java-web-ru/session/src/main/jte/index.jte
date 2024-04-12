@import exercise.dto.MainPage
@import exercise.util.NamedRoutes

@param MainPage page

@template.layout.page(content = @`
    <div>
        @if(page.getName() != null)
            <h1>Welcome ${page.getName().toString()}</h1>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" name="Logout" value="Logout">
            </form>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Login</a>
        @endif
    </div>
`)
