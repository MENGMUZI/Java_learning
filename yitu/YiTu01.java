import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-23  18:59
 * @description:
 */
public class YiTu01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //和骰子的数量
        int num = scanner.nextInt();
        //目标的点数
        int target = scanner.nextInt();
        //骰子的点数
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int[] eachArr = new int[6];
            for (int j = 0; j < 6 ; j++) {
                eachArr[j] = scanner.nextInt();
            }
            list.add(eachArr);
        }
        int f = list.get(0)[5];
        int[][] result = new int[num + 1][target + 1];
        result[0][0] = 1;
        for (int row = 0; row <= num ; row++) {
            for (int number = row; number <= target; number++) {
                for (int i = 1; i <= f && number -i >=0 ; i++) {
                    result[row][number] = (result[row][number] + result[row-1][number-i]);
                }
            }
        }
        System.out.println(result[num][target]);
    }

}
