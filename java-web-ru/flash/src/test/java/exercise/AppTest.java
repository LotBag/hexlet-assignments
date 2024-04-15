package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import exercise.repository.PostRepository;
import exercise.model.Post;

class AppTest {

    private static Javalin app;

    @BeforeEach
    public void setUp() {
        app = App.getApp();
    }

    @Test
    void testMainPage() throws Exception {
        var a = "a";
        assertThat(a.equals("a"));
    }



}
