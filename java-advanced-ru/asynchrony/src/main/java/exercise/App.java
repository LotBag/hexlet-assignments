package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static Path getAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    public static CompletableFuture<String> unionFiles(String filePath1, String filePath2, String resultFilePath) {
        CompletableFuture<String> firstText = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(getAbsolutePath(filePath1));
            } catch (IOException e) {
                System.out.println("We have a problem reading the file " + filePath1
                + e.getMessage());
            }
            return null;
        });

        CompletableFuture<String> secondText = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(getAbsolutePath(filePath2));
            } catch (IOException e) {
                System.out.println("We have a problem reading the file " + filePath2
                        + e.getMessage());
            }
            return null;
        });

        CompletableFuture<String> result = firstText.thenCombine(secondText, (text1, text2) -> {
            String resultText = text1 + text2;

            try {
                Files.writeString(getAbsolutePath(resultFilePath), resultText, StandardOpenOption.CREATE);
            } catch(IOException e) {
                System.out.println("We have a problem writing the file " + resultFilePath);
            }
            return resultText;
        });

        return result;

        }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        App.unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt",
                "src/main/resources/result.txt");
        // END
    }
}

