package dataStructures.old;

import java.util.HashMap;
import java.util.Map;

public class TheMap {
    public static void main(String[] args) {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person("Alex", 20));
        personMap.put(2, new Person("Ali", 22));
        personMap.put(4, new Person("Priyanka", 29));
        personMap.put(3, new Person("Ali", 22));

        System.out.println(personMap);
        System.out.println(personMap.size());
        System.out.println(personMap.get(3));
        System.out.println(personMap.containsKey(4));
        System.out.println(personMap.keySet());
        System.out.println(personMap.entrySet());
        System.out.println(personMap.values());

        personMap.entrySet().forEach(x -> System.out.println(x.getKey() + ", " + x.getValue().getName() + ", " + x.getValue().getAge()));
        personMap.forEach((k, v) -> System.out.println(k + ", " + v.getName() + ", " + v.getAge()));
    }
}
