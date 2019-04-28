package Sorting_basic;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-28  12:54
 * @description: 比较SelectionSort, InsertionSort和BubbleSort三种排序算法的性能效率
 */
public class SelectionVSInsertionVSBubble {
    //比较SelectionSort, InsertionSort和BubbleSort三种排序算法的性能效率
    public static void main(String[] args) {
        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr2);
        SortTestHelper.testSort("Sorting_basic.BubbleSort_Comparable",arr3);
        SortTestHelper.testSort("Sorting_basic.BubbleSort_Comparable2",arr4);
        System.out.println();

        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr2);
        SortTestHelper.testSort("Sorting_basic.BubbleSort_Comparable",arr3);
        SortTestHelper.testSort("Sorting_basic.BubbleSort_Comparable2",arr4);
        System.out.println();

        // 测试3 测试完全有序的数组
        // 对于完全有序的数组，冒泡排序法也将成为O(n)级别的算法
        swapTimes = 0;
        N= 10000000;    // 由于插入排序法和冒泡排序法在完全有序的情况下都将成为O(n)算法
        // 所以我们的测试数据规模变大，为1000,0000
        System.out.println("Test for ordered array, size = " + N);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        //SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr2);
        SortTestHelper.testSort("Sorting_basic.BubbleSort_Comparable",arr3);
        SortTestHelper.testSort("Sorting_basic.BubbleSort_Comparable2",arr4);
        System.out.println();
    }

}
