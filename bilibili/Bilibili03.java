import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-20  19:30
 * @description:
 */
public class Bilibili03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//商品的数量
        int M = scanner.nextInt();//背包的承重
        int[] weight = new int[N];
        int[] value = new int[N];
        for (int i = 0; i < N ; i++) {
            weight[i] = scanner.nextInt();
        }

        for (int i = 0; i < N ; i++) {
            value[i] = scanner.nextInt();
        }
        int[][] dp = new int[N+1][M+1];//生成一个dp数组
        for (int i = 1; i <= N ; i++) {
            int w = weight[i-1], v =value[i-1];
            for (int j = 1; j <= M ; j++) {
                if(j >= w){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);

                }else{
                  dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][M]);
    }

}
