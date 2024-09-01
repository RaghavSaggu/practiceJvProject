package stringRelated;

public class StringPalindromeCheck {
    public static void main(String[] args) {
        String originalString = "ava";
        String reversedString = new StringBuilder(originalString).reverse().toString();
        if(originalString.equals(reversedString)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
