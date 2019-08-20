import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-15  18:55
 * @description:
 */
public class Test360_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//二维数组的行数
        int m = scanner.nextInt();//二维数组的列数
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    result += arr[i][j] * 4 + 2;
                }
                if (i != 0) {
                    result -= Math.min(arr[i][j], arr[i - 1][j]) * 2;
                }
                if (j != 0) {
                    result -= Math.min(arr[i][j], arr[i][j - 1]) * 2;
                }
            }
        }
        System.out.println(result);

    }

}
