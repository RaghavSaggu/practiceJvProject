package InheritanceProgramming;

class Parent {
    int member;

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public void show() {
        System.out.println("Show in Parent");
    }

    public final void showFinal() {
        System.out.println("Final Show in Parent");
    }

    public static void showStatic() {
        System.out.println("Static method in Parent");
    }

    public void run() {
        System.out.println("parent is running");
        walk();
    }

    public void walk() {
        System.out.println("parent is walking");
    }
}

class Child extends Parent {
    @Override
    public void run() {
        System.out.println("child is running");
        super.run();
    }

    @Override
    public void walk() {
        System.out.println("child is walking");
        super.walk();
    }
}

interface FatherInterface {
    void show();

    static void showStatic() {
        System.out.println("Static method in FatherInterface");
    }
}

interface MotherInterface {
    void showString();

    static void showStatic() {
        System.out.println("Static method in MotherInterface");
    }
}

class Runner extends Parent implements FatherInterface, MotherInterface {
    public void runnerMethod() {
        Runner obj = new Runner();
        FatherInterface objOfFather = new Runner();
        MotherInterface objOfMother = new Runner();

        obj.show();
        super.show();
        obj.show();
        objOfFather.show();
        obj.showFinal();
        showStatic();
        Parent.showStatic();
    }

    @Override
    public void showString() {
        System.out.println("ShowString in Test");
    }

    @Override
    public void show() {
        System.out.println("Show in Test");
    }

    public static void showStatic() {
        System.out.println("Static method in Test");
    }
}

public class InheritanceProgram {

    public static void main(String... args) {
        Parent p = new Child();
        p.run();
    }

}
