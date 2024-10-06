package dataStructures.old;

import java.util.HashMap;
import java.util.Map;

public class HashCodeExperiments {
    public static void main(String[] args) {
        Map<Person, Diamond> personDiamondMap = new HashMap<>();
        personDiamondMap.put(new Person("Alex", 19), new Diamond("Red"));
        personDiamondMap.put(new Person("Alexa", 19), new Diamond("Black"));

        System.out.println(new Person("Alex", 19).hashCode());
        System.out.println(new Person("Alex", 19).hashCode());

        System.out.println(personDiamondMap.size());
        System.out.println(personDiamondMap.get(new Person("Alex", 19)));
    }

    private static class Diamond {
        String color;

        public Diamond(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
//2. Code Question 2
//        Amazon Logistics has multiple delivery centers from which products are sent.
//
//        In one such delivery center, parcels are placed in a sequence where the ith parcel has a weight of weight[i]. A shipment is constituted of a contiguous segment of parcels. The shipment imbalance of a shipment is defined as the difference between the maximum and minimum weights within a shipment.
//
//        Given the arrangement of parcels, find the sum of shipment imbalance of all the shipments that can be formed from the given sequence of parcels.
//
//Example
//        weights = [1, 2, 3]
//
//        The shipment imbalance calculations for each possible shipment are shown below.
//
//        The total shipment imbalance is 0 + 0 + 0 + 1 + 1 + 2 = 4.
//
//
//        Function Description
//
//        Complete the function getTotalImbalance in the editor below.
//
//
//
//        getTotalImbalance has the following parameter:
//
//        int weight[n]: the weights of the parcels
//
//
//
//        Returns
//
//        long_int: the sum of shipment imbalance of all shipments
//
//
//
//Constraints
//
//        1 ≤ n ≤ 105
//        1 ≤ weight[i]  ≤ 105
//
//
//        Input Format For Custom Testing
//        Sample Case 0
//        Sample Input For Custom Testing
//
//        STDIN         FUNCTION
//        -----         --------
//        3        →    weight[] size n = 3
//        3        →    weight = [3, 2, 3]
//        2
//        3
//        Sample Output
//
//        3
//Explanation
//
//        The possible shipments are as follows:
//
//        The total imbalance is 0 + 0 + 0 + 1 + 1 + 1 = 3.
//
//        1. Code Question 1
//        Amazon Web Services (AWS) offers learning opportunities for computer science students in a series of courses. Upon completing a course, AWS awards the student with an electronic learning badge. Before signing up for further courses, a student assigns each badge a value based on interest:
//
//        1 means that the student is interested
//        -1 means that the student is not interested
//
//
//        To perform some analysis on the students' interest in the courses, given the array badges and their elements, either 1 or -1, find a subarray of maximum length such that the product of all the elements in the subarray is 1.
//
//        A subarray is a contiguous group of elements in an array.
//
//Example
//        There are 6 subjects:
//        badges = [1, -1, -1, 1, 1, -1]
//
//        The student is interested in Security, IoT, and DBMS as indicated in the badges array.
//
//        These are a few of the subarrays whose product is equal to 1:
//
//        beginning and ending indices (0, 0), the length of the subarray is 1
//        indices (0, 4), the length of the subarray is 5
//        indices (1, 4), length of the subarray is 4
//        indices (1, 2), length of the subarray is 2
//
//
//The maximum subarray length whose product is equal to 1 is length 5. Return 5.
//
//Function Description
//
//        Complete the function maxSubarrayLength in the editor below.
//
//        maxSubarrayLength has the following parameter:
//
//        int badges[n]: the student's interest in each of the subjects, either 1 or -1
//
//Returns
//
//        int: the maximum length subarray with a product of 1
//
//Constraints
//        2 ≤ n ≤ 2 · 10 5
//        each badges[i] is either -1 or 1
//        There will be at least one non-empty subarray that satisfies the given condition.
//
//
//        Input Format For Custom Testing
//        Sample Case 0
//        Sample Input For Custom Testing
//
//        STDIN    FUNCTION
//        -----    --------
//        6    →   badges size, n = 6
//        1    →   badges = [1, -1, -1, -1, 1, 1]
//        -1
//        -1
//        -1
//        1
//        1
//        Sample Output
//
//        4
//        Explanation
//
//        These are a few of the subarrays whose product is equal to 1:
//
//        Subarray with indices from (0, 2), length of the subarray is 3.
//        Subarray with indices from (1, 2), length of the subarray is 2.
//        Subarray with indices from (2, 5), length of the subarray is 4.
//        Subarray with indices from (4, 5), length of the subarray is 2.
//        The maximum subarray length whose product is equal to 1 is length 4

