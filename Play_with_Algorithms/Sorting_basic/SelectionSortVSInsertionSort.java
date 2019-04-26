package Sorting_basic;


import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-27  01:13
 * @description: 比较选择排序和插入排序
 */
public class SelectionSortVSInsertionSort {

    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    public static void main(String[] args) {
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N,0,N);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);//是深拷贝

        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr1);
        SortTestHelper.testSort("Sorting_basic.SelectionSort_Comparable",arr2);
        //此时，此时，插入排序比选择排序性能略低
    }

}
