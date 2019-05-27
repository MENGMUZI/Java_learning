package Sorting_basic;

/**
 * @author : mengmuzi
 * create at:  2019-04-27  00:54
 * @description: 插入排序
 */
public class InsertionSort_Comparable {
    // 我们的算法类不允许产生任何实例
    private InsertionSort_Comparable(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素arr[i]合适的插入位置
            //写法1
//            for (int j = i; j > 0 ; j--) {
//                if(arr[j].compareTo(arr[j-1]) < 0){
//                    swap(arr,j,j-1);
//                }else{
//                    break;
//               }
//          }
            //写法2
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1])<0 ; j--) {
                swap(arr,j,j-1);
            }
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

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //测试Insertion
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
        SortTestHelper.testSort("Sorting_basic.InsertionSort_Comparable",arr);
    }

}
