package dataStructures.old;

import java.util.HashSet;
import java.util.Set;

public class TheSet {
    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Person("Ali", 19));
        personSet.add(new Person("Ali", 19));
        personSet.add(new Person("Ali", 20));

        System.out.println(personSet.size());
        System.out.println(personSet);
        System.out.println(personSet.contains(new Person("Ali", 19)));
    }
}
