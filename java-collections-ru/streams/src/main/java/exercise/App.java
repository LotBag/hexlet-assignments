package exercise;

import java.util.List;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> list) {
        return list.stream()
                .filter(email -> email.endsWith("gmail.com") | email.endsWith("yandex.ru") | email.endsWith("hotmail.com"))
                .count();
    }
}
// END
