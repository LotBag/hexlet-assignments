@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h1>Current user</h1>
        <h3>${page.getUser().getFirstName() + page.getUser().getLastName()}</h3>
    `
)
