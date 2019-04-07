/**
 * @author : mengmuzi
 * create at:  2019-04-07  15:06
 * @description: 快速排序
 */
public class FastSortByPartation {
    public static void quickSort(int[] arr , int L , int R){
        if(L < R){
           int[] p = partition(arr,L,R);
           quickSort(arr,L,p[0]-1);
           quickSort(arr,p[1]+1,R);
        }
    }
    private static int[] partition(int[] arr, int L, int R) {
        int less = L-1;
        int more = R;
        while(L < more){
            if(arr[L] < arr[R]){
                swap(arr, ++less ,L++);
            }else if(arr[L] > arr[R]){
                swap(arr, --more ,L);
            }else{
                L ++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};

    }

    private static void swap(int[] arr, int i, int j) {
        //int temp = arr[i];
        //arr[i] = arr[j];
        //arr[j] = temp;

        if(arr[i] == arr[j]){
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,7,8,4,6,2,4,5,10,7};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
