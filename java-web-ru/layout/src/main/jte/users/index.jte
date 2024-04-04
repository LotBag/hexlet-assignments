@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <h1>Users</h1>
        @for(var user : page.getUsers())
         <h3>${user.getFirstName() + user.getLastName()}</h3>
        @endfor
    `
)
