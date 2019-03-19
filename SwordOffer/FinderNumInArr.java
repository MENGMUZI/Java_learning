/**
 * @author : mengmuzi
 * create at:  2019-03-19  21:18
 * @description: 在二维数组中找数
 */
public class FinderNumInArr {

    public boolean Find(int target, int[][] array){
        int R = 0;//右上角横坐标为0
        int C = array[0].length-1;//右上角纵坐标
        while(R <= array.length-1 && C >= 0){
            if(array[R][C] == target){
                return true;
            }else if(array[R][C] < target){
                R++;
            }else{
                C++;
            }
        }
        return false;

    }

}
