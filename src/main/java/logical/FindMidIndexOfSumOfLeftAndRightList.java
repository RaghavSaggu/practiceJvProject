package logical;

public class FindMidIndexOfSumOfLeftAndRightList {
    public static void main(String[] args) {
        long[] arr = {6,1,1,1,-3,5,1,-2,5};
        System.out.println(workerMethod(arr, arr.length));
    }

    private static int workerMethod(long[] arr, int length) {
        if(arr.length <= 0 || arr.length != length)
            return 0;
        int N = length, eligibleIndex = 0;
        long sumHead = 0;
        for(int i = 0; i < N - 1; i++) {
            if(eligibleIndex > 0) break;
            sumHead += arr[i];
            long sumTail = 0;
            for(int j = N - 1; j > i; j--) {
                sumTail += arr[j];
                if(sumTail > sumHead) break;
                if(sumHead == sumTail && i == j - 2) {
                    eligibleIndex = i + 2;
                    break;
                }
            }
        }
        return eligibleIndex;
    }
}
