package dataStrucures;

import java.util.Arrays;

public class UltraCommerceProblemToMerge2Arrays {
    public static boolean performanceLogsPrintFlag = false;

    public static void main(String[] args) {
        UltraCommerceProblemToMerge2Arrays runner = new UltraCommerceProblemToMerge2Arrays();
        try {
            int[] a1 = {1, 5, 7, 10, 15, 19, 25, 36, 38, 40};
            int[] a2 = {3, 7, 8, 9, 10, 11, 13};

            int[] sortedMergedAr =
//                    runner.conventionalApproachUsingBubbleSort(a1, a2);
//                    runner.mergeIfArraysAreNotSorted(a1, a2);
                    runner.algorithmByRaghu2MergeSortedArrays(a1, a2);
            Arrays.stream(sortedMergedAr).forEach(i -> System.out.print(i + " "));
            System.out.println("\nCOMPLETED Algorithm");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private int[] algorithmByRaghu2MergeSortedArrays(int[] a, int[] b) throws IllegalArgumentException {
        if (a == null || b == null || a.length == 0 || b.length == 0) throw new IllegalArgumentException("Empty array not allowed");
        if (isArrayNotSorted(a)) throw new IllegalArgumentException("Array in first argument is not sorted");
        if (isArrayNotSorted(b)) throw new IllegalArgumentException("Array in second argument is not sorted");

        int performanceIter = 0;

        try {
            int responseArraySize = a.length + b.length;
            int[] responseArray = new int[responseArraySize];
            boolean aCompleted = false, bCompleted = false;
            for (int i = 0, j = 0, k = 0; i < responseArraySize; i++) {
                performanceIter++;
                if (aCompleted) {
                    // copy all rest b's elems in responseArray
                    responseArray[i] = b[k];
                    k++;
                } else if (bCompleted) {
                    // copy all rest a's elems in responseArray
                    responseArray[i] = a[j];
                    j++;
                } else {
                    // if traversing through both the arrays, check which element will win from a and b and increment counter accordingly
                    if (a[j] < b[k]) {
                        responseArray[i] = a[j];
                        if (j < a.length - 1) {
                            j++;
                        } else {
                            aCompleted = true;
                        }
                    } else {
                        responseArray[i] = b[k];
                        if (k < b.length - 1) {
                            k++;
                        } else {
                            bCompleted = true;
                        }
                    }
                }
            }
            return responseArray;
        } finally {
            if(performanceLogsPrintFlag)
                System.out.println("Total iter done in algorithmByRaghu2MergeSortedArrays: " + performanceIter);
        }
    }

    private boolean isArrayNotSorted(int[] arrayToCheck) throws IllegalArgumentException {
        if(arrayToCheck == null || arrayToCheck.length == 0) throw new IllegalArgumentException("Empty array not allowed");
        int performanceIter = 0;
        try {
            for (int i = 0; i < arrayToCheck.length - 1; i++) {
                // If at any index next is greater than current, array gonna marked as not sorted one
                performanceIter++;
                if (arrayToCheck[i] > arrayToCheck[i + 1])
                    return true;
            }
            return false;
        } finally {
            if(performanceLogsPrintFlag)
                System.out.println("Total iter done in isArrayNotSorted: "+ performanceIter);
        }
    }

    public int[] mergeIfArraysAreNotSorted(int[] a, int[] b) {
        int performanceIter = 0;
        try {
            int[] responseArray = new int[a.length + b.length];
            boolean firstCompleted = false;
            for (int i = 0, j = 0; i < responseArray.length; i++, j++) {
                performanceIter++;
                if (i < a.length) {
                    responseArray[i] = a[j];
                    if (j == a.length - 1 && !firstCompleted) {
                        firstCompleted = true;
                        j = -1; // resetting the counter
                    }
                } else {
                    responseArray[i] = b[j];
                }
            }

            // now we have to sort the Arr
            myBubbleSortVersion(responseArray);
            return responseArray;
        } finally {
            if(performanceLogsPrintFlag)
                System.out.println("Total iter done in mergeIfArraysAreNotSorted: " + performanceIter);
        }
    }

    private void myBubbleSortVersion(int[] arrayToSort) {
        int performanceIter = 0;
        try {
            int rotations = arrayToSort.length;
            boolean swapped;
            while (rotations > 1) {
                performanceIter++;
                swapped = false;
                for (int i = 0; i < rotations - 1; i++) {
                    performanceIter++;
                    if (arrayToSort[i] > arrayToSort[i + 1]) {
                        int temp = arrayToSort[i];
                        arrayToSort[i] = arrayToSort[i + 1];
                        arrayToSort[i + 1] = temp;
                        swapped = true;
                    }
                }
                if(!swapped) break;
                rotations--;
            }
        } finally {
            if(performanceLogsPrintFlag)
                System.out.println("Total iter done in enhancedBubbleSort: " + performanceIter);
        }
    }

    public int[] conventionalApproachUsingBubbleSort(int[] a, int[] b) {
        int performanceIter = 0;
        try {// Step 1: Combine the arrays
            int[] combinedArray = new int[a.length + b.length];

            // Copy elements of a's to combinedArray
            for (int i = 0; i < a.length; i++) {
                combinedArray[i] = a[i];
                performanceIter++;
            }
            // Copy elements of b's to combinedArray
            for (int i = 0; i < b.length; i++) {
                combinedArray[a.length + i] = b[i];
                performanceIter++;
            }

            // Step 2: Sort the combined array using Bubble Sort
            bubbleSort(combinedArray);

            return combinedArray;
        } finally {
            if(performanceLogsPrintFlag)
                System.out.println("Total iter done in conventionalApproach: " + performanceIter);
        }
    }

    // Bubble Sort Algorithm
    public void bubbleSort(int[] array) {
        int performanceIter = 0;
        try {
            int n = array.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                performanceIter++;
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    performanceIter++;
                    if (array[j] > array[j + 1]) {
                        // Swap array[j] and array[j + 1]
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                // If no two elements were swapped in the inner loop, then break
                if (!swapped) {
                    break;
                }
            }
        } finally {
            if(performanceLogsPrintFlag)
                System.out.println("Total iter done in bubbleSort: " + performanceIter);
        }
    }
}