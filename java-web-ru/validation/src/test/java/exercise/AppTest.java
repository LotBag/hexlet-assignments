package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import exercise.repository.ArticleRepository;
import exercise.model.Article;
import java.util.List;

class AppTest {

    private static Javalin app;
    private static String baseUrl;



    @Test
    void test() {
        assertThat("a".equals("a"));
    }


}
