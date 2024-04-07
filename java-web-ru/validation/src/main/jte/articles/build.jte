@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(content = @`

    <div>
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
    </div>
    <form action="/articles" method="post">
        <label>
            Articles title
            <input type="text" required name="title" value="${page.getTitle()}">
        </label>
        <label>
            Articles content
            <input type="text" required name="content" value="${page.getContent()}">
        </label>
        <input type="submit" name="create">
    </form>
`)
