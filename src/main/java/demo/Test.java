package demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        // main method
        List<Student> studentList = Arrays.asList(new Student(8, "Raghav"),
                new Student(2, "Karan"),
                new Student(2, "Rupinder"),
                new Student(1, "Pardeep"),
                new Student(3, "Kuljeet"),
                new Student(4, "Shubham"),
                new Student(5, "Japjeet"),
                new Student(6, "Pushpinder"),
                new Student(7, "Kewal"));
//        studentList.stream()
//                .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
////                .sorted()
//                .forEach(integer -> System.out.println(integer));
        studentList.get(0).show();
    }
}

class Person {
    void show() throws NullPointerException {
        System.out.println("I am person");
    }
}

class Student extends Person implements Comparable {
    Integer id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return (31 * 1) + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.compareTo(((Student)obj).id) == 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.id.compareTo(((Student)o).id) != 0 ? this.id.compareTo(((Student)o).id) : this.name.compareTo(((Student) o).name);
    }

    @Override
    void show() throws RuntimeException {
        System.out.println("I am a student as a person");;
    }
}