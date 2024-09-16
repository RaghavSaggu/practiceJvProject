package GenericProgramming;


class Box<X> {
    public X value;

    public X getValue() {
        return value;
    }

    public void setValue(X value) {
        this.value = value;
    }
}

public class GenericProgram {
    public static void main(String[] args) {
        Box<Integer> box= new Box<>();
        box.setValue(1);
        Integer s = box.getValue();
        System.out.println(s);
        Box<String> boxString= new Box<>();
        boxString.setValue("Test");
        System.out.println(boxString.getValue());
    }
}
