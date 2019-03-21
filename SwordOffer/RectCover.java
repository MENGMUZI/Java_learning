/**
 * @author : mengmuzi
 * create at:  2019-03-20  15:33
 * @description: 矩阵覆盖（还是一个斐波那切数列）
 */
public class RectCover {

    public int RectCover(int target){
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int sum = 0;
        int before = 1;
        int curr = 2;
        if (target> 2) {
            for (int i = 2; i < target; i++) {
                sum = before + curr;
                before = curr;
                curr = sum;
            }
        }
        return sum;
    }

}
