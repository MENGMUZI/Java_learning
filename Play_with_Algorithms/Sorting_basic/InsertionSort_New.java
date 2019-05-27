package Sorting_basic;

/**
 * @author : mengmuzi
 * create at:  2019-04-27  01:42
 * @description: 改进后的插入排序减少交换的次数
 */
public class InsertionSort_New {

    //我们的算法类不允许产生任何实例
    private InsertionSort_New(){}
    public static void sort(Comparable[] arr){

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Comparable element = arr[i];
            int j = i;//用j保存元素element应该插入的位置
            for (; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--) {
                arr[j] = arr[j-1];//将前面的数向后退，腾出地方
            }
            arr[j] = element;
        }
    }
    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
    //测试Insertion
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr);
    }


}
