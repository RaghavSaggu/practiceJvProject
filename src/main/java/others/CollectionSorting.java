package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSorting {
    public static void main(String[] args) {
        comparableAndComparator();
    }

    private static void comparableAndComparator() {
        Comparator<Student> studentNameWiseComparator = (o1, o2) -> o1.name.compareTo(o2.name) != 0 ? o1.name.compareTo(o2.name) : o1.age.compareTo(o2.age);

        List<Student> students = new ArrayList();
        students.add(new Student(30, "Raghav"));
        students.add(new Student(32, "Karan"));
        students.add(new Student(31, "Ritu"));
        students.add(new Student(31, "Abhishek"));
        students.add(new Student(26, "Kanika"));
        students.add(new Student(29, "Harish"));
        students.add(new Student(29, "Raghav"));

        Collections.sort(students);
        students.forEach(stud -> System.out.println(stud));
//        System.out.println("Using comparator");
//        Collections.sort(students, studentNameWiseComparator);
//        students.forEach(stud -> System.out.println(stud));
    }

    static class Student implements Comparable<Student> {
        Integer age;
        String name;

        public Student(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student [age=" + age + ", name=" + name + "]";
        }

        @Override
        public int compareTo(Student o) {
            return this.age.compareTo(o.age) != 0 ? this.age.compareTo(o.age) : this.name.compareTo(o.name);
        }
    }
}

