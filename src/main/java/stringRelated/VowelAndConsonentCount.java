package stringRelated;

public class VowelAndConsonentCount {
    public static void main(String[] args) {
        String str = "raghav weds kanika in 6 months";
        int vowels = 0, consonants = 0, digits = 0, others = 0;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1)
                vowels++;
            else if (Character.isLetter(c))
                consonants++;
            else if (Character.isDigit(c))
                digits++;
            else
                others++;
        }
        System.out.println(
                "Vowels: " + vowels +
                ", Consonants: " + consonants +
                ", Digit: " + digits +
                ", Others: " + others
        );
    }
}
