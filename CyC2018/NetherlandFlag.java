/**
 * @author : mengmuzi
 * create at:  2019-04-07  14:09
 * @description: 荷兰国旗问题
 */
public class NetherlandFlag {
    public static int[] partation(int[] arr , int l ,int r , int num){
        int less = l - 1;
        int more = r + 1;
        int curr = l;
        while(curr < more){
            if(arr[curr] < num){
                swap(arr,++less,curr++);
            }else if(arr[curr] > num){
                swap(arr,--more,curr++);
            }else{
                curr ++;
            }
        }
        return new int[]{less + 1, more - 1};

    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

}
