package com.gradescope.sort;

/**
 * Sorting Algorithms Assignment Template
 *
 * Students must implement:
 *  - quickSort(int[] arr)
 *  - mergeSort(int[] arr)
 *  - getMergeSortCallCount()
 *
 * Do NOT use built-in sorting methods (e.g., Arrays.sort()).
 * You may add private helper functions if needed.
 */
public class Sorter {

    // === Variable to track the number of mergeSort() calls ===
    private static int mergeSortCallCount = 0;

    /**
     * Performs the QuickSort algorithm on the given array.
     * @param arr The array to be sorted in ascending order.
     */
    public static void quickSort(int[] arr) {
        // TODO: Implement quicksort using recursion
        // You may create a helper: quickSortHelper(arr, low, high)
    }

    /**
     * Performs the MergeSort algorithm on the given array.
     * Also counts how many times the mergeSort() recursive function is called.
     * @param arr The array to be sorted in ascending order.
     */
    public static void mergeSort(int[] arr) {
        // TODO: Implement merge sort
        // Hint: Increment mergeSortCallCount each time mergeSort() is invoked.
        // You may create a helper: mergeSortHelper(arr, left, right)
    }

    /**
     * Returns the total number of times mergeSort() was called.
     * This helps analyze recursion depth and complexity.
     */
    public static int getMergeSortCallCount() {
        return mergeSortCallCount;
    }

    /**
     * Resets the merge sort call counter (for multiple runs).
     * The autograder will call this between tests.
     */
    public static void resetMergeSortCallCount() {
        mergeSortCallCount = 0;
    }

    /**
     * Utility function to print array for visualization.
     */
    public static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Optional local main test
    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 4, 2};
        System.out.println("Before: " + arrayToString(nums));
        quickSort(nums);
        System.out.println("After QuickSort: " + arrayToString(nums));

        int[] nums2 = {10, 7, 8, 9, 1, 5};
        resetMergeSortCallCount();
        mergeSort(nums2);
        System.out.println("After MergeSort: " + arrayToString(nums2));
        System.out.println("mergeSort() called " + getMergeSortCallCount() + " times");
    }
}
