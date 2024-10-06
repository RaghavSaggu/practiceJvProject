package dataStructures.old;

import java.util.LinkedList;
import java.util.ListIterator;

public class TheLinkedList {
    public static void main(String[] args) {
        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("Alex", 21));
        linkedList.add(new Person("Bob", 22));
        linkedList.add(new Person("Cindy", 28));
        linkedList.push(new Person("Candy", 19));
        linkedList.addFirst(new Person("Ali", 45));
        linkedList.addLast(new Person("Suraj", 27));

//        System.out.println(linkedList);
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.peek());
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.poll());
//        System.out.println(linkedList.size());

        ListIterator<Person> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();
        System.out.println();

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
