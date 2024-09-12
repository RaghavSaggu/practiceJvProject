package logical;

public class IfKCharactersMatchedInString {

    public static void main(String[] args) {
        String s1 = "demo1", s2 = "de2ty";
        int K = 3;

        if (s1.length() < K || s2.length() < K) {
            System.out.println("no match");
            return;
        }

        int matchesFound = 0;
        for (int i = 0; i < s1.length() && matchesFound < K; i++) {
            if (s2.contains(s1.substring(i, i+1))) {
                matchesFound++;
            }
        }

        System.out.println(matchesFound >= K ? K + " matches found in strings" : "Didn't matched the criteria");
    }
}
