package others;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionStreamDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee("raghav", 10000);
        Employee emp2 = new Employee("devdutt", 20000);
        Employee emp3 = new Employee("brahm dutt", 9000);
        Employee emp4 = new Employee("Zebray", 19000);
        Employee emp5 = new Employee("devdutt", 12000);

        System.out.println(emp2 == emp5);
        System.out.println(emp2.equals(emp5));

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees = employees.stream().
                filter(emp -> emp.getSalary() > 10000).
                sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary())).   //TODO understand this process
                collect(Collectors.toList());

        System.out.println(employees);

//        System.out.println("a compare b : " + Integer.valueOf(1).compareTo(Integer.valueOf(2)));
//        System.out.println("a compare b : " + Integer.valueOf(1).compareTo(Integer.valueOf(1)));
//        System.out.println("a compare b : " + Integer.valueOf(2).compareTo(Integer.valueOf(1)));
    }
}

class Employee {
    String name;
    Integer salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object employee) {
        return this.name.equals(((Employee) employee).getName()) &&
                this.salary.equals(((Employee) employee).getSalary());
    }

    @Override
    public String toString() {
        return "others.Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}