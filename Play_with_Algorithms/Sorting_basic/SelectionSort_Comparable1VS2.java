package Sorting_basic;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-28  10:49
 * @description: 改进后的选择排序的性能测试
 */
public class SelectionSort_Comparable1VS2 {
    // 比较SelectionSort, SelectionSort2和InsertionSort两种排序算法的性能效率
    // 优化后，插入排序比选择排序性能略好
    // 对于有序性强的数组，插入排序远远优于选择排序
    public static void main(String[] args) {
        int N = 20000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New",arr2);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr3);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable2",arr4);
        System.out.println();

        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New",arr2);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr3);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable2",arr4);
        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New",arr2);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr3);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable2",arr4);
        System.out.println();


    }

}
