package stringRelated;

import java.util.HashSet;
import java.util.Set;

//Given a String, find the first repeated character in it using Stream functions? "a happy world"
public class FirstRepeatedCharacterInfoSysR2 {

    public static void main(String[] args) {
        String input = "a happy world";
        Character firstRepeated = findFirstRepeatedCharacter(input);

        if (firstRepeated != null) {
            System.out.println("First repeated character: " + firstRepeated);
        } else {
            System.out.println("No repeated characters found.");
        }
    }

    public static Character findFirstRepeatedCharacter(String input) {
        Set<Character> seen = new HashSet<>();

        return input.chars().mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .filter(c -> !seen.add(c))
                .findFirst().orElse(null);
    }
}