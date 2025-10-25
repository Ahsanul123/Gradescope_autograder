package com.gradescope.sort;

/**
 * Student Demo Solution for Sorting Assignment.
 * 
 * Implements QuickSort and MergeSort with recursion
 * and tracks the number of times mergeSort() is called.
 */
public class Sorter {

    // === Variable to track how many times mergeSort() is invoked ===
    private static int mergeSortCallCount = 0;

    // === QUICK SORT IMPLEMENTATION ===

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // === MERGE SORT IMPLEMENTATION ===

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSortCallCount++;
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        // mergeSortCallCount++;
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // === HELPER FUNCTIONS ===

    public static int getMergeSortCallCount() {
        return mergeSortCallCount;
    }

    public static void resetMergeSortCallCount() {
        mergeSortCallCount = 0;
    }

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

    // === OPTIONAL LOCAL TESTING MAIN ===
    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 4, 2};
        System.out.println("Before QuickSort: " + arrayToString(nums));
        quickSort(nums);
        System.out.println("After QuickSort:  " + arrayToString(nums));

        int[] nums2 = {10, 7, 8, 9, 1, 5};
        resetMergeSortCallCount();
        System.out.println("\nBefore MergeSort: " + arrayToString(nums2));
        mergeSort(nums2);
        System.out.println("After MergeSort:  " + arrayToString(nums2));
        System.out.println("mergeSort() called " + getMergeSortCallCount() + " times");
    }
}
