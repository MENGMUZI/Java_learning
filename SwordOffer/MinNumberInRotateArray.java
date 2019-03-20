/**
 * @author : mengmuzi
 * create at:  2019-03-20  09:51
 * @description: 旋转数组中的最小数字
 */
public class MinNumberInRotateArray {


    public int minNumberInRotateArray1(int[] array){
        //笨方法
        if(array.length < 1){
            return 0;
        }
        int min = array[array.length-1];
        for(int i=array.length-1 ;i > 0; i--){
            if( array[i]>=array[i-1] ){
                min = array[i-1];
            }else{
                break;
            }
        }
        return min;
    }

    //二分查找的方法
    public int minNumberInRotateArray2(int[] array){
        int length = array.length;
        int target = array[length-1];
        int l = 0;
        int h = length-1;
        if(length < 1){
            return 0;
        }
        while(l < h){
            int mid = l + (h - l)/2;
            if(array[mid] == target){
                h = mid;
            }else if(array[mid] > target){
                l = mid +1;
            }else{
                target = array[mid];
                h = mid;
            }
        }
        return array[h];
    }

}
