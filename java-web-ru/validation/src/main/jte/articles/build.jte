@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(content = @`
    @if (page.getErrors() != null)
        <ul>
            @for(var errorList : page.getErrors().values())
                @for(var errors : errorList)
                    <li>
                        ${errors.getMessage()}
                    </li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
        <label>
            Articles title
            <input type="text" required name="title">
        </label>
        <label>
            Articles content
            <input type="text" required name="content">
        </label>
        <input type="submit" name="create">
    </form>
`)
