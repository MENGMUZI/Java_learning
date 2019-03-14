/**
 * @author : mengmuzi
 * create at:  2019-03-14  14:08
 * @description:
 */
public class Code_11_MaxGap {

    public static int maxGap(int[] arrs){
        if(arrs == null || arrs.length < 2){
            return 0;
        }
        int len = arrs.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //先找到最大的和最小的数
        for(int i = 0 ; i < len ; i++){
            min = Math.min(min,arrs[i]);
            max = Math.max(max,arrs[i]);
        }
        if(min == max){
            return 0;
        }
        //新建N+1个桶，然后记录桶中是否存放了数，其中最大的数和最小的数
        boolean[] hasNum = new boolean[len+1];
        int[] mins = new int[len+1];
        int[] maxs = new int[len+1];
        int bid = 0;//确定一个数去几号桶
        for (int i = 0; i < arrs.length ; i++ ){
            bid = bucket(arrs[i],len,min,max);
            //记录桶中是否存放了数，其中最大的数和最小的数
            mins[bid] = hasNum[bid]? Math.min(mins[bid],arrs[i]) : arrs[i];
            maxs[bid] = hasNum[bid]? Math.max(maxs[bid],arrs[i]) : arrs[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int beforeMax = maxs[0];
        int index = 1;
        for( index =1; index <= len ; index++){
            if(hasNum[index]){
                res = mins[index]-beforeMax > res ? mins[index]-beforeMax : res;
                beforeMax = maxs[index];
            }
        }
        return res;

    }

    private static int bucket(long num, long len , long min , long  max ) {

        return (int)((num-min)*len/(max-min));
    }

    public static void main(String[] args){
        int[] arrs = {1,122,3,55,5,9,123};
        int result = maxGap(arrs);
        System.out.println("result ="+result);
    }


}
