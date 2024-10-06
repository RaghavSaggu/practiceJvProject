package dataStructures.old;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheQueue { // FIFO

    public static void main(String[] args) {
        queue();
//        priorityQue();
    }

    static Short bringShort(int val) {
        return (short)val;
    }

    private static void priorityQue() {
        PriorityQueue<Short> pq = new PriorityQueue<>();

        pq.add(bringShort(1));
        pq.add(bringShort(2));
        pq.add(bringShort(3));

        System.out.println(pq.size());
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.size());
    }

    private static void queue() {
        Queue<Person> onlineOrders = new LinkedList<>();
        onlineOrders.add(new Person("Alex", 21));
        onlineOrders.add(new Person("Bob", 22));
        onlineOrders.add(new Person("Cindrella", 19));

        System.out.println(onlineOrders.size());
        System.out.println(onlineOrders.peek());
        System.out.println(onlineOrders.poll());
        System.out.println(onlineOrders.size());
        System.out.println(onlineOrders.peek());
    }
}
