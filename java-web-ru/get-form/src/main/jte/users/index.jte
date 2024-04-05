@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>Users</h1>
        <form action="/users" method="get">
            <label>
                Search
                <input type="search" name="term" value="${page.getTerm()}">
            </label>
            <input type="submit" value="POGnali">
        </form>
        <div>
            @for(var user : page.getUsersList())
                <h3>${user.getFirstName()} ${user.getLastName()}</h3>
            @endfor
        </div>
        `
)
