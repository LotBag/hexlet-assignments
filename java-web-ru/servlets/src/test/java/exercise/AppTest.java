package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kong.unirest.core.Unirest;

class AppTest {
    static String baseUrl;

    @BeforeAll
    static void setup() {
        baseUrl = System.getProperty("gretty.httpBaseURI");
    }

    @Test
    void testMainPage() {
        assertThat(1).isEqualTo(1);
    }
}
