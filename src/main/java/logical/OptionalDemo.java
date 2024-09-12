package logical;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[8];
//        String[] words = {"T0", "T1", "T2", "T3", "T4", null, "5", ""};
        Optional<String> checkNull = Optional.ofNullable(words[1]);
        if(checkNull.isPresent())
            System.out.println(checkNull.get().toLowerCase());
        else
            System.out.println("String is empty");
    }
}
