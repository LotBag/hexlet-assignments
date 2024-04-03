@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="eng">
    <body>
        @if(page.getUserList().isEmpty())
            <p>User not found</p>
        @else
            <h1>${page.getHeader()}</h1>
            @for(var users : page.getUserList())
                <div>
                    <h2>${users.toString()}</h2>
                </div>
        @endfor
        @endif
    </body>
</html>>
