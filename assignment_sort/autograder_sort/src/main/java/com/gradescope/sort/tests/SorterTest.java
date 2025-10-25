package com.gradescope.sort.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.gradescope.sort.Sorter;
import java.util.Arrays;
import com.gradescope.jh61b.grader.GradedTest;

/**
 * Autograder test suite for QuickSort and MergeSort.
 * Each test compares student output with Arrays.sort() results.
 * Also verifies mergeSort() recursion call counts.
 */
public class SorterTest {

    /** Utility: creates a defensive copy of an array. */
    private int[] makeCopy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    /** Utility: asserts array is sorted ascending. */
    private void assertSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue("Array not sorted correctly at index " + i, arr[i] <= arr[i + 1]);
        }
    }

    // ======== QUICK SORT TESTS ========

    @Test(timeout = 1000)
    @GradedTest(name = "Test QuickSort basic case", max_score = 15)
    public void testQuickSortBasic() {
        int[] arr = {5, 3, 8, 4, 2};
        int[] expected = makeCopy(arr);
        Arrays.sort(expected);

        Sorter.quickSort(arr);

        assertArrayEquals("QuickSort failed", expected, arr);
        assertSorted(arr);
    }

    @Test(timeout = 1000)
    @GradedTest(name = "Test QuickSort already sorted", max_score = 10)
    public void testQuickSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = makeCopy(arr);
        Arrays.sort(expected);

        Sorter.quickSort(arr);

        assertArrayEquals("QuickSort changed a sorted array", expected, arr);
        
    }

    // ======== MERGE SORT TESTS ========

    @Test(timeout = 1000)
    @GradedTest(name = "Test MergeSort basic case", max_score = 15)
    public void testMergeSortBasic() {
        int[] arr = {9, 1, 6, 3, 5};
        int[] expected = makeCopy(arr);
        Arrays.sort(expected);

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(arr);

        assertArrayEquals("MergeSort failed", expected, arr);
        assertSorted(arr);

    }

    @Test(timeout = 1000)
    @GradedTest(name = "Test MergeSort on negative values", max_score = 10)
    public void testMergeSortNegativeValues() {
        int[] arr = {0, -5, 2, -1, 3, -2};
        int[] expected = makeCopy(arr);
        Arrays.sort(expected);

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(arr);

        assertArrayEquals("MergeSort failed on negatives", expected, arr);
    }

    @Test(timeout = 1000)
    @GradedTest(name = "Test MergeSort on empty array", max_score = 10)
    public void testMergeSortEmpty() {
        int[] arr = {};
        int[] expected = {};

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(arr);

        assertArrayEquals("Empty array changed", expected, arr);
    }

    @Test(timeout = 1000)
    @GradedTest(name = "Test MergeSort call count growth", max_score = 10)
    public void testMergeSortCallCountIncreasesWithArraySize() {
        int[] small = {1, 2};
        int[] medium = {1, 2, 3, 4};
        int[] large = {1, 2, 3, 4, 5, 6, 7, 8};

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(small);
        int smallCount = Sorter.getMergeSortCallCount();

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(medium);
        int mediumCount = Sorter.getMergeSortCallCount();

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(large);
        int largeCount = Sorter.getMergeSortCallCount();

        assertTrue(
            String.format("Expected increasing recursion calls: small=%d, medium=%d, large=%d", smallCount, mediumCount, largeCount),
            largeCount > mediumCount && mediumCount > smallCount
        );
    }

    @Test(timeout = 1000)
    @GradedTest(name = "Test MergeSort random large array", max_score = 20)
    public void testMergeSortRandomLarge() {
        int[] arr = {10, -3, 5, 7, 2, 1, 0, -10, 8, 9};
        int[] expected = makeCopy(arr);
        Arrays.sort(expected);

        Sorter.mergeSort(arr);

        assertArrayEquals("MergeSort failed on large random array", expected, arr);
    }

    @Test(timeout = 1000)
    @GradedTest(name = "Test MergeSort stable behavior", max_score = 10)
    public void testMergeSortStability() {
        int[] arr = {3, 3, 3, 2, 2, 1};
        int[] expected = makeCopy(arr);
        Arrays.sort(expected);

        Sorter.resetMergeSortCallCount();
        Sorter.mergeSort(arr);

        assertArrayEquals("MergeSort failed on duplicates", expected, arr);
    }
}
