@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    @if (!page.getPosts().isEmpty())
        <nav aria-label="Page navigation">
            <ul>
                <li>
                    <a href="/posts?page=${page.getCurrentPage() - 1}">Назад</a>
                </li>
                <li>
                    <a href="/posts?page=${page.getCurrentPage() + 1}">Вперед</a>
                </li>
            </ul>
        </nav>
    @endif
    <table>
        @for(var post : page.getPosts())
            <tr>
                <td>
                    <a href="/posts/${post.getId()}">${post.getName()}</a>
                </td>
                <td>
                    ${post.getBody()}
                </td>
            </tr>
        @endfor
    </table>
`
)