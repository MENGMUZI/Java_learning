/**
 * @author : mengmuzi
 * create at:  2019-03-17  15:15
 * @description: 插入排序
 */
public class InsertSort {

    public static int[] insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }

            }
        }
        return arr;
    }

    private static void swap(int arr[],int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,7,5,3,4};
        int[] test= insertSort(arr);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
        }
    }

}
