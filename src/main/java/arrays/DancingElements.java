package arrays;

// if element on odd is greater than element on odd then print shuffle of them
public class DancingElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3};
        callWorkerMethod(arr, arr.length);
    }

    private static void callWorkerMethod(int[] arr, int length) {
        if (arr.length <= 0 || arr.length != length)
            return;
        for (int i = 0; i < length-1; i += 2) {
            if (arr[i + 1] > arr[i])
                System.out.print(arr[i + 1] + " " + arr[i] + " ");
            else
                System.out.print(arr[i] + " " + arr[i + 1] + " ");
        }
        if(length % 2 != 0)
            System.out.println(arr[length-1]);
    }
}
