/**
 * @author : mengmuzi
 * create at:  2019-04-07  16:44
 * @description: 快速排序寻找第K大的元素
 */
public class TopKQuickSelect {
    public int findKthElement(int[] nums , int k){
        k = nums.length - k;
        int l = 0, h = nums.length -1;
        while(l < h){
            int result = partition(nums,l,h);
            if(result == k){
               break;
            }else if(result < k){
                l = result + 1;
            }else {
                h = result - 1;
            }
        }
        return nums[k];

    }

    private int partition(int[] nums, int l, int h) {
        int less = l-1;
        int more = h;
        while(l < more){
            if(nums[l] > nums[h]){
                swap(nums,l,--more);
            }else if(nums[l] < nums[h]){
                swap(nums,l++,++less);
            }else{
                l ++;
            }
        }
        swap(nums,h,more);
        return less+1;
    }

    private void swap(int[] arr, int i, int j) {
        if(arr[i] == arr[j]){
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
