@import exercise.dto.users.UserPage
@param UserPage userPage

@template.layout.page(
    content = @`
        <h1>Current user</h1>
        <h3>${userPage.toString()}</h3>
    `
)
