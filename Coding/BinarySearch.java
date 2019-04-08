import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-02  11:44
 * @description: 二分法
 */
public class BinarySearch {
    public static int binarySearch(int target, int[] arr){
        int l = 0;
        int h = arr.length-1;
        while(l <= h){
            int mid = l +(h-l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,23,4,5,54,3,545};
        Arrays.sort(nums);
        int result = binarySearch(4,nums);
        System.out.println(result);
    }

}
