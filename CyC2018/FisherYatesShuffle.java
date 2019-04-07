import java.util.BitSet;
import java.util.Random;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  21:58
 * @description: 洗牌算法
 */
/*
* 用于随机打乱一组数，并且时间复杂度为 O(N)。

* 算法的基本思想是，每次从一组数中随机选出一个数，然后与最后一个数交换位置，并且不再考虑最后一个数。
*
* */
public class FisherYatesShuffle {

    public static void shuffle(int[] nums){
        Random random = new Random();
        for(int i = nums.length-1; i >=0; i--){
            int randomnum = random.nextInt(i+1);//[0,i]
            swap(nums,i,randomnum);
        }
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static void swap(int[] nums, int i, int randomnum) {
        int temp = nums[i];
        nums[i] = nums[randomnum];
        nums[randomnum] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        shuffle(nums);
    }

}
