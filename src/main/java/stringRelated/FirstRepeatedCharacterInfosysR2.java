package stringRelated;

import java.util.*;
import java.util.stream.Collectors;

//Given a String, find the first repeated character in it using Stream functions? "a happy world"
public class FirstRepeatedCharacterInfosysR2 {

    public static void main(String[] args) {
        findRepeatedNumbers();
    }

    public static void findFirstRepeatedCharacter() {
        String input = "a happy world";
        Set<Character> seen = new HashSet<>();

        Character firstRepeated = input.chars().mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .filter(c -> !seen.add(c))
                .findFirst().orElse(null);

        if (firstRepeated != null) {
            System.out.println("First repeated character: " + firstRepeated);
        } else {
            System.out.println("No repeated characters found.");
        }
    }

    public static void findRepeatedNumbers() {
        List<Integer> actualList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3);
        Set<Integer> onlyThoseThatArentInSet = new HashSet<>();

        List<Integer> duplicateElementsFromActualList = actualList.stream().filter(c -> !onlyThoseThatArentInSet.add(c)).collect(Collectors.toList());
        System.out.println(onlyThoseThatArentInSet);
        System.out.println(onlyThoseThatArentInSet.add(1));
        System.out.println(onlyThoseThatArentInSet.add(11));
        System.out.println(duplicateElementsFromActualList);
    }
}