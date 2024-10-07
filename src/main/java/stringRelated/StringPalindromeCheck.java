package stringRelated;

public class StringPalindromeCheck {
    public static void main(String[] args) {
        String testString = "racecar"; // Example input
        boolean isPalindrome = isPalindrome(testString);
        System.out.println(testString + " is a palindrome: " + isPalindrome);
    }


    public static boolean isPalindrome(String str) {
        // Clean the string (optional): remove spaces, convert to lowercase
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeStringBuilder(str);
//        return isPalindromeBruteForce(str);
//        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    private static boolean isPalindromeStringBuilder(String testString) {
        String reversed = new StringBuilder(testString).reverse().toString();
        return testString.equals(reversed);
    }

    private static boolean isPalindromeBruteForce(String testString) {
        char[] charA = testString.toCharArray();
        for (int i = 0, j = charA.length - 1; i < charA.length / 2; i++, j--) {
            if (charA[i] != charA[j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeRecursive(String str, int left, int right) {
        // Base case: If left index crosses right, we've checked all characters
        if (left >= right) {
            return true;
        }
        // Check if characters at left and right indices are the same
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        // Move towards the center
        return isPalindromeRecursive(str, left + 1, right - 1);
    }

}
