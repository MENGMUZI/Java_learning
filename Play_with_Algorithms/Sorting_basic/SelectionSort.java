package Sorting_basic;

/**
 * @author : mengmuzi
 * create at:  2019-04-21  00:16
 * @description: 选择排序
 */
public class SelectionSort {
    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}
    public static void selectSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            //寻找[i, n)区间里的最小值的索引
            int minindex = i;
            for(int j= i+1; j<n; j++){
                if(arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            swap(arr,minindex,i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.selectSort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();

    }

}
