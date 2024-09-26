package functionalInterfaces;
import java.util.function.Predicate;

public class CustomFunctionalInterfaceDemo {
    public static void main(String[] args) {
        int b = 10;

        FunctionalInterfaceToIncreaseValueByA obj = (value, a) -> System.out.println("Inside custom made consumer value is consumed to print result: " + (value + a));
        CheckId5UsingPredicate obj1 = new CheckId5UsingPredicate();
        System.out.println(obj1.test(7) ? "yes its five" : "Its something else");
        obj.incrementBy(b, 20);
        System.out.println("B is still: " + b);
    }
}

class CheckId5UsingPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer t) {
        return (t.intValue() == 5) ? true : false;
    }
}

interface FunctionalInterfaceToIncreaseValueByA {
    int a = 10;
    void incrementBy(int value, int a);
}