import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-04-07  01:34
 * @description: 数组中的第K个最大元素(215)
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
