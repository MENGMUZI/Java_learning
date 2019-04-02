import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-04-02  09:34
 * @description: ThreeSum 用于统计一个数组中和为 0 的三元组数量。
 */
public class ThreeNumsSum {

    //方法一：采用一个3重for循环
    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> list2 = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j <len ; j++) {
                for (int k = j+1; k <len ; k++) {
                    if (nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        hashSet.add(list1);
                    }
                }

            }

        }
        list2.addAll(hashSet);
        return list2;
    }

    public static void main(String[] args) {
        ThreeNumsSum tns = new ThreeNumsSum();
        int[] nums = {-3,1,-2,0,-4,-5,2,4,6,5,7,-122,122};
        List<List<Integer>> results = tns.threeSum(nums);
        System.out.println(results);
    }

}
