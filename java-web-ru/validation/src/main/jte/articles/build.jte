@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(content = @`

    <div>
        @if(page.getErrors() != null)
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
        @endif
    </div>
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
