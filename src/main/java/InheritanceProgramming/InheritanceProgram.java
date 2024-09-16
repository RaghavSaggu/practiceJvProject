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

public class InheritanceProgram extends Parent implements FatherInterface, MotherInterface {

    public static void main(String... args) {
        InheritanceProgram runner = new InheritanceProgram();
        runner.runnerMethod();
    }

    public void runnerMethod() {
        InheritanceProgram obj = new InheritanceProgram();
        Parent objOfParent = new InheritanceProgram();
        FatherInterface interfaceObject = new InheritanceProgram();

        obj.show();
        super.show();
        obj.show();
        interfaceObject.show();
        objOfParent.show();
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
