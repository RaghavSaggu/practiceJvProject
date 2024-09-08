package dataStrucures;

import java.util.*;
import java.util.LinkedList;

public class MakeStringValidByRemovingMinParentheses {

    public static void main(String[] args) {
        String input = "(a)())()";
        List<String> result = removeInvalidParentheses(input);
        System.out.println("Valid strings after removing minimum parentheses: " + result);
    }

    private static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // Check if current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If we found valid strings, no need to generate further levels
            if (found) continue;

            // Generate new strings by removing one parenthesis
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;

                String next = current.substring(0, i) + current.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }

        return result;
    }

    private static boolean isValid(String s) {
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') counter++;
            if (c == ')') counter--;
            if (counter < 0) return false;
        }
        return counter == 0;
    }
}

