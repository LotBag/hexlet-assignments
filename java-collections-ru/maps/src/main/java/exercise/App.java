package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
        public static Map<String, Integer> getWordCount(String string) {
                String[] wordsArray = string.split(" ");
                Map<String, Integer> wordsCount = new HashMap<>();
                int counter;
                if (string.isEmpty()){
                        return wordsCount;
                }

                for (var word : wordsArray) {
                        if (!wordsCount.containsKey(word)) {
                                wordsCount.put(word, 1);
                        } else {
                                counter = wordsCount.get(word) + 1;
                                wordsCount.put(word, counter);
                        }
                }
                return wordsCount;
        }

        public static String toString(Map<String, Integer> map) {
                if (map.isEmpty()){
                        return "{}";
                }
                StringBuilder result = new StringBuilder("{");
                for (var key : map.keySet()) {
                        result.append("\n  ").append(key).append(": ").append(map.get(key));
                }
                result.append("\n}");
                return result.toString();
        }
}
//END
