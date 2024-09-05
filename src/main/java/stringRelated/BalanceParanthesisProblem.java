package stringRelated;

import java.util.Stack;

public class BalanceParanthesisProblem {
    public static void main(String[] args) {
        String input = "{[()]}";
//        if (isBalancedGivenOpeningAndClosing(input, '(', ')') &&
//                isBalancedGivenOpeningAndClosing(input, '{', '}') &&
//                isBalancedGivenOpeningAndClosing(input, '[', ']'))
//        if (isBalancedUsingStrBuilder(input))
        if (isBalancedUsingStack(input))
        {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
    }

    public static boolean isBalancedUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default: // Ignore non-parenthesis characters
                    break;
            }
        }
        // If stack is empty, all opening parentheses are matched
        return stack.isEmpty();
    }

    public static boolean isBalancedGivenOpeningAndClosing(String s, char openingParan,  char closingParan) {
        int balance = 0; // Counter for open parentheses
        for (char c : s.toCharArray()) {
            if (c == openingParan) {
                balance++; // Increment for opening parenthesis
            } else if (c == closingParan) {
                balance--; // Decrement for closing parenthesis
            }
            if (balance < 0) {
                // More closing parentheses than opening ones
                return false;
            }
        }
        // Balance should be zero if parentheses are balanced
        return balance == 0;
    }

    public static boolean isBalancedUsingStrBuilder(String s) {
        return isBalancedHelper(s, 0, new StringBuilder());
    }

    private static boolean isBalancedHelper(String s, int index, StringBuilder stack) {
        if (index == s.length()) {
            return stack.length() == 0;
        }

        char current = s.charAt(index);

        if (current == '(' || current == '{' || current == '[') {
            stack.append(current);
        } else if (current == ')' || current == '}' || current == ']') {
            if (stack.length() == 0) {
                return false;
            }
            char last = stack.charAt(stack.length() - 1);
            if ((current == ')' && last != '(') ||
                    (current == '}' && last != '{') ||
                    (current == ']' && last != '[')) {
                return false;
            }
            stack.deleteCharAt(stack.length() - 1);
        }

        return isBalancedHelper(s, index + 1, stack);
    }
}