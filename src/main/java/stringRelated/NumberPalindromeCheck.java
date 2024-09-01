package stringRelated;

public class NumberPalindromeCheck {
    static boolean isNegativeNeedToCheck = true;

    public static void main(String[] args) {
        Integer originalNumber = -101, reversedNumber = 0;
        boolean isNegative = false;
        if(originalNumber == null) {
            System.out.println("No number given to check palindrome");
            return;
        }
        if(isNegativeNeedToCheck && originalNumber < 0) {
            isNegative = true;
            originalNumber *= -1;
        } else if (!isNegativeNeedToCheck && originalNumber < 0) {
            System.out.println("No need to check palindrome, numbes is negative");
            return;
        }

        String originalNumString = "", reversedNumString = "";
        originalNumString = originalNumber.toString();
        reversedNumString = new StringBuilder(originalNumString).reverse().toString();

        reversedNumber = Integer.valueOf(reversedNumString);
        if(isNegative) {
            originalNumber *= -1;
            reversedNumber *= -1;
        }
        if(originalNumber.compareTo(reversedNumber) == 0) {
            System.out.println("Number is palindrome");
        } else {
            System.out.println("Number is not palindrome");
        }
    }
}
