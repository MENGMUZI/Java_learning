import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-03  19:59
 * @description:
 */
public class Test03 {

    public static void main(String[] args) {
        int dp[][] = new int[1000][1000];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        dp[0][1] = 1;
        dp[1][n] = 1;
        dp[1][2] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][n] + dp[i - 1][2];
                } else if (j == n) {
                    dp[i][j] = dp[i - 1][1] + dp[i - 1][n - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        System.out.println(dp[m][1]);
    }

}
