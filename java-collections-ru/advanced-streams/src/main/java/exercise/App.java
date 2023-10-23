package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String string) {
        String[] split = string.split("\"");
        return Arrays.stream(split)
                .map(s -> s.split(","))
                .flatMap(Stream::of)
                .map(s -> s.replace("X_FORWARDED_HOME=/ cd", "fuu"))
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END

