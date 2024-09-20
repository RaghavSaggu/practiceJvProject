package stringRelated;

import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen", str2 = "silent";
        boolean isAnagram = checkIfStringsAnagram2(str1, str2);
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
        if(str1.isEmpty() || str2.isEmpty())
            return false;

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static boolean checkIfStringsAnagram2(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        char[] a1 = str1.toCharArray();
        char[] a2 = str2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        for(int i = 0; i<a1.length; i++) {
            if(a1[i] != a2[i])
                return false;
        }
        return true;
    }
}
