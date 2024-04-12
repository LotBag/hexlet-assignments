@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes

@param LoginPage page

@template.layout.page(content = @`
    <div>
        @if(!page.getError() == null)
            ${page.getError()}
        @endif
    </div>
    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <label>
                <input type="text" placeholder="Nickname" name="name">
            </label>
            <label>
                <input type="password" placeholder="Password" required name="password">
            </label>
            <input type="submit" name="Login" value="Login">
        </form>
    </div>
`)
