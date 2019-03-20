/**
 * @author : mengmuzi
 * create at:  2019-03-20  15:14
 * @description: 变态跳台阶
 */
public class JumpFloorII {

    //方法一：递归版本
    public int JumpFloorII(int target){
        if(target == 1){
            return 1;
        }
        return JumpFloorII(target-1)*2;
    }

    //方法二：直接使用MAth.pow函数
    public int JumpFloorII2(int target){
        if(target <=0){
            return 0;
        }
        return (int)Math.pow(2,target-1);
    }
    //方法三：非递归版本算乘方
    public int JumpFloorii3(int target){
        int res = 0;
        if(target == 1){
            return 1;
        }else{
            res = 1;
            for(int i =2;i<=target;i++){
                res = res * 2;
            }
        }
        return res;
    }

}
