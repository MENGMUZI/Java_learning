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
    //方法二：通过将数组先排序，对两个元素求和，并用二分查找方法查找是否存在该和的相反数，如果存在，就说明存在三元组的和为 0。
    //应该注意的是，只有数组不含有相同元素才能使用这种解法，否则二分查找的结果会出错。
    public List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> list2 = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j <len ; j++) {
                //利用二分搜索查找两数和的相反数
                int result = binarySearchI(nums,nums[i]+nums[j]);
                if(result > j){   //不然会重复统计 !!!! 这里很重要
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[result]);
                    hashSet.add(list1);
                }

            }

        }
        list2.addAll(hashSet);
        return list2;
    }

    public int binarySearchI(int[] arrs,int target){
        target = target * (-1);
        int low = 0;
        int high = arrs.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arrs[mid] == target){
                return mid;
            }else if(arrs[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    //方法三： 更有效的方法是先将数组排序，然后使用双指针进行查找，时间复杂度为 O(N2)。
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list2 = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i <len-2 ; i++) {
            int l = i + 1;
            int h = len - 1;
            int target = -nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while (l < h){
                int sum = nums[l] + nums[h];
                if(sum == target){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[l]);
                    list1.add(nums[h]);
                    list1.add(nums[i]);
                    hashSet.add(list1);//这里面其实不需要再使用hashset了，已经去重了
                    while(l < h && nums[l] == nums[l+1]) l++;
                    while(l < h && nums[h] == nums[h-1]) h--;
                    l ++;
                    h --;
                }else if(sum < target){
                    l++;
                }else{
                    h--;
                }
            }
        }
        list2.addAll(hashSet);
        return list2;
    }
    
    public static void main(String[] args) {
        ThreeNumsSum tns = new ThreeNumsSum();
        //int[] nums = {-3,1,-2,0,-4,-5,2,4,6,5,7,-122,122};
        int[] nums = {0,0,0} ;
        List<List<Integer>> results = tns.threeSum(nums);
        //List<List<Integer>> otherresults = tns.threeSum2(nums);
        System.out.println("result:  "+ results);
        //System.out.println("otherresult:   "+ otherresults);
        List<List<Integer>> anotherresults = tns.threeSum3(nums);
        System.out.println("anotherresult:  "+ anotherresults);

    }

}
