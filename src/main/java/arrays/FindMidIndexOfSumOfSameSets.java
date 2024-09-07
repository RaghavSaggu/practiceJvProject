package arrays;

public class FindMidIndexOfSumOfSameSets {
    public static void main(String[] args) {
        long[] arr = {2,2,1,1,5,6,-2,1,1};
        System.out.println(callWorkerMethod(arr, arr.length));
    }

    private static int callWorkerMethod(long[] arr, int length) {
        if(arr.length <= 0 || arr.length != length)
            return 0;
        int lenArr = length, response = 0;
        long sumHead = 0, sumTail = 0;
        for(int i = 0, j = lenArr-1; i<lenArr/2; i++, j--) {
            sumHead += arr[i];
            sumTail += arr[j];
            if(sumHead == sumTail) {
                response = i+1;
                break;
            }
        }
        return response;
    }
}
