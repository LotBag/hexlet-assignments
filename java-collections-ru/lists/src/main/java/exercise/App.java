package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String character, String word) {
        character = character.toLowerCase();
        word = word.toLowerCase();
        List<Character> chars = new ArrayList<>();
        List<Character> wordChars = new ArrayList<>();
        int charsCounter = 0;
        int tmpB;
        int tmpA;

        for (var i = 0; i < character.length(); i++) {
            chars.add(character.charAt(i));
        }

        for (var i = 0; i < word.length(); i++) {
            wordChars.add(word.charAt(i));
        }
        System.out.println(wordChars);
        System.out.println(chars);

        for (char a : wordChars) {
            for (char b : chars) {
                if (a == b) {
                    tmpA = wordChars.indexOf(a);
                    System.out.println(tmpA);
                    wordChars.set(tmpA, 'W');
                    tmpB = chars.indexOf(b);
                    System.out.println(tmpB);
                    chars.set(tmpB, 'Q');
                    charsCounter++;
                    System.out.println(wordChars);
                    System.out.println(chars);
                    System.out.println(charsCounter);
                    break;

                }
            }
        }
        System.out.println(charsCounter);
        return charsCounter >= word.length();
    }
}
//END
