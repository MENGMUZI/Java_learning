/**
 * @author : mengmuzi
 * create at:  2019-03-20  14:54
 * @description: 小青蛙跳台阶
 */
public class JumpFloor {

    public int JumpFoolFunction(int target){
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int nums = 0;
        int before2 = 1;
        int before1 = 2;
        if(target > 2){
            for(int i =2;i<target;i++){
                nums = before1 + before2;
                before2 =before1;
                before1 = nums;
            }
        }
        return nums;
    }
}
