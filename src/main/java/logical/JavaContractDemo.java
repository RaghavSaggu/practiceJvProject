package logical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaContractDemo {
    public static void main(String[] args) {
        // main method
        List<Student> studentList = Arrays.asList(
                new Student(8, "Raghav"),
                new Student(2, "Karan"),
                new Student(2, "Rupinder"),
                new Student(1, "Pardeep"),
                new Student(3, "Kuljeet"),
                new Student(4, "Shubham"),
                new Student(5, "Japjeet"),
                new Student(6, "Pushpinder"),
                new Student(7, "Kewal"));
        studentList.stream()
                .sorted((o1, o2) -> o2.getId().compareTo(o1.getId()))
//                .sorted()
                .forEach(integer -> System.out.println(integer));

        Student obj1 = new Student(8, "Raghav");
        Student obj2 = new Student(8, "Raghav");
        System.out.println("equals using == operator: " + (obj1 == obj2));
        System.out.println("equals using equals method: " + obj1.equals(obj2));
        System.out.println("Hash code of obj1: " + obj1.hashCode());
        System.out.println("Hash code of obj2: " + obj2.hashCode());

        Map<Student, Student> map = new HashMap<>();
        map.put(obj1, obj1);
        map.put(obj2, obj2);
        for(Map.Entry<Student, Student> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + map.values());
        }
    }
}

class Student implements Comparable {
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

    /* java contract says if we will override equals, we must override hascode too;
     * check by commenting overriden hashcode method
     * */
    @Override
    public int hashCode() {
        return (31 * 1) + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.compareTo(((Student)obj).id) == 0;
    }
    // java contract ends here

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
}