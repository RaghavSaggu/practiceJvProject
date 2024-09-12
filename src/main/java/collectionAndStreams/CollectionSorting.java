package collectionAndStreams;

import java.util.*;

public class CollectionSorting {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(30, "Raghav"),
                new Student(32, "Karan"),
                new Student(31, "Ritu"),
                new Student(31, "Abhishek"),
                new Student(26, "Kanika"),
                new Student(29, "Harish"),
                new Student(29, "Raghav"));

        students.forEach(System.out::println);
        System.out.println("================================= Printing same post operation =================================");
        printSortedUsingComparator(students);
    }

    private static void printSortedUsingComparable(List<Student> students) {
        Collections.sort(students);
        students.forEach(System.out::println);
    }

    private static void printSortedUsingComparator(List<Student> students) {
        Comparator<Student> studentNameWiseComparator = (s1, s2) -> s1.name.compareTo(s2.name) != 0 ? s1.name.compareTo(s2.name) : s1.age.compareTo(s2.age);
        Collections.sort(students, studentNameWiseComparator);
        students.forEach(System.out::println);
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
        public int compareTo(Student comparingStudent) {
            return this.age.compareTo(comparingStudent.age) != 0 ? this.age.compareTo(comparingStudent.age) : this.name.compareTo(comparingStudent.name);
        }
    }
}

