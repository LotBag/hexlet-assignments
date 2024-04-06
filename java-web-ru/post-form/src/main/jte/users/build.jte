@template.layout.page(
    content = @`
        <h1>Create users</h1>
        <form action="/users" method="post">
            <div>
                <label>
                    First name
                    <input type="text" name="firstName">
                </label>
            </div>
            <div>
                <label>
                    Last name
                    <input type="text" name="lastName">
                </label>
            </div>
            <div>
                <label>
                    Email
                    <input type="email" name="email">
                </label>
            </div>
            <div>
                <label>
                    Password
                    <input type="password" name="password">
                </label>
            </div>
            <input type="submit" name="Register">
        </form>
    `
)