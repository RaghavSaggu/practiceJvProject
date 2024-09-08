package stringRelated;

import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen", str2 = "silent";
        boolean isAnagram = checkIfStringsAnagram(str1, str2);
        if(isAnagram)
            System.out.println(str1 + " and " + str2 + " are anagram");
        else
            System.out.println(str1 + " and " + str2 + " are NOT anagram");
    }

    private static boolean checkIfStringsAnagram(String str1, String str2) {
        if(str1 == null || str2 == null) {
            System.out.println("NULL String not allowed");
            return false;
        }
        if(str1.isEmpty() && str2.isEmpty())
            return true;
        if(str1.isEmpty() || str2.isEmpty())
            return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
