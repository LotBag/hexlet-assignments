package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String character, String word) {
        List<Character> chars = new ArrayList<>();
        List<Character> wordChars = new ArrayList<>();

        for (var i = 0; i < character.length(); i++) {
            chars.add(character.charAt(i));
        }

        for (var i = 0; i < word.length(); i++) {
            wordChars.add(word.charAt(i));
        }

        for (char wordChar : wordChars) {
            for (char listChar : chars) {
                if (wordChar == listChar) {
                    wordChars.remove(wordChar);
                    chars.remove(listChar);
                }
            }
        }

        return wordChars.isEmpty();
    }
}
//END
