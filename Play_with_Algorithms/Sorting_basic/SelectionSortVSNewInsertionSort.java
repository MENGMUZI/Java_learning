package Sorting_basic;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-27  02:10
 * @description: 改进后的插入排序VS选择排序
 */
public class SelectionSortVSNewInsertionSort {

    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    // 优化后，插入排序比选择排序性能略好
    // 对于有序性强的数组，插入排序远远优于选择排序

    public static void main(String[] args) {
        int N = 20000;
        //1.一般的测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);

        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New",arr2);
        System.out.println();//SelectionSort_Comparable:417ms ; InsertionSort_New:1ms


        //2.有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");
        arr1 = SortTestHelper.generateRandomArray(N,0,3);
        arr2 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New",arr2);
        System.out.println();//SelectionSort_Comparable:359ms ; InsertionSort_New:1ms

        //3.测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);
        arr1 = SortTestHelper.generateNearlyOrderedArray(N,swapTimes);
        arr2 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_New",arr2);
        System.out.println();//SelectionSort_Comparable:259ms ; InsertionSort_New:0ms

    }


}
