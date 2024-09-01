package others;

public class IfKCharactersMatchedInString {

    public static void main(String[] args) {
        String s1 = "demo1", s2 = "de12mo";
        int K = 3;
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();

        if(s1CharArray.length < K || s2CharArray.length < K) {
            System.out.println("no match");
            return;
        }

        int matchesFound = 0;
        for(int i = 0; i < s1CharArray.length && matchesFound < K; i++) {
            for (int j = 0; j< s2CharArray.length && matchesFound < K; j++) {
                if(s1CharArray[i] == s2CharArray[j]) {
                    matchesFound++;
                    break;
                }
            }
        }

        if(matchesFound >= K) {
            System.out.println("matched");
        } else {
            System.out.println("No match");
        }
    }
}
