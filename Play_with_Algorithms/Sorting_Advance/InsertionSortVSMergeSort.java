package Sorting_Advance;

import Sorting_basic.SortTestHelper;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-29  01:37
 * @description: 比较InsertionSort和MergeSort两种排序算法的性能效率
 */
public class InsertionSortVSMergeSort {

    public static void main(String[] args) {
        int N = 50000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable", arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New", arr3);
        SortTestHelper.testSort("Sorting_Advance.MergeSort_Comparable", arr2);
        System.out.println();

        // 测试2 测试近乎有序的数组
        // 对于近乎有序的数组, 数组越有序, InsertionSort的时间性能越趋近于O(n)
        // 所以可以尝试, 当swapTimes比较大时, MergeSort更快
        // 但是当swapTimes小到一定程度, InsertionSort变得比MergeSort快
        int swapTimes = 1000;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable", arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New", arr3);
        SortTestHelper.testSort("Sorting_Advance.MergeSort_Comparable", arr2);
        System.out.println();

    }

}
