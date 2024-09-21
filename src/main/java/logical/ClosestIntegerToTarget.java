package logical;

public class ClosestIntegerToTarget {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7, 8, 9, 10};
        int target = 5;
        int closest = closestNumber2(a, target);
        System.out.println("The closest number to " + target + " is " + closest);
    }

    public static int closestNumber2(int[] a, int target) {
        int closest = a[0];
        for(int i=0; i<a.length; i++) {
            if(Math.abs(a[i] - target) < Math.abs(closest - target)) {
                closest = a[i];
            }
        }
        return closest;
    }


    public static int closestNumber(int[] a, int target) {
        int closest = a[0];
        for (int num : a) {
            if (Math.abs(num - target) < Math.abs(closest - target)) {
                closest = num;
            }
        }
        return closest;
    }
}
