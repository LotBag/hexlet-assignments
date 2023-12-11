package exercise;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        Files.writeString(path, car.serialize());
    }

    public static Car extract(Path path) throws IOException {
        Files file = null;
        String string = file.readString(path);
        return Car.unSerialize(string);
    }
}
// END

