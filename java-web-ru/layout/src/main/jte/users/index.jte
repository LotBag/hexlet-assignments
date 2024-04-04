@import exercise.dto.users.UsersPage
@import exercise.dto.users.UserPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>Users</h1>
        @for(UserPage user : page)
         <h3>${user.toString()}</h3>
        @endfor
    `
)
