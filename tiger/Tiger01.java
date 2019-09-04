/**
 * @author : mengmuzi
 * create at:  2019-09-02  20:47
 * @description:
 */
public class Tiger01 {
    public static int bubbleSort(int[] arr) {
        int swapTimes = 0;
        if (arr == null || arr.length < 2) {
            return 0;
        }
        for (int end = arr.length-1 ; end > 0 ; end --) {
            for (int i = 0; i < end ; i++) {
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                    swapTimes ++;
                }
            }
        }
        return swapTimes;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
