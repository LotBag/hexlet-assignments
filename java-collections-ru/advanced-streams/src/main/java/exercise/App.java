package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String string) {
        String[] split = string.split("\n");
        return Arrays.stream(split)
                .filter(s -> s.startsWith("environment"))
                .map(s -> s.replace("\"", ""))
                .map(s -> s.replace("environment=", ""))
                .map(s -> s.split(","))
                .flatMap(Stream::of)
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END

