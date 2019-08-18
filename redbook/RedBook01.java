import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  15:00
 * @description:
 */
public class RedBook01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String str = scanner.next();
        String subStr = str.substring(1,str.length()-1);
        String[] arr = subStr.split(",");
        int[] arrNum = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            arrNum[i] = Integer.parseInt(arr[i]);
        }
        //动态规划
        int result = dpMethod(arrNum,number);
        System.out.println(result);
        

    }
    public static int dpMethod(int[] arr,int aim){
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= aim ; j++) {
            if(j % arr[0] == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j <= aim ; j++) {
                int temp= 0;
                for (int k = 0; k*arr[i] <= j ; k++) {
                    temp += dp[i-1][j-k*arr[i]];
                }
                dp[i][j] = temp;
            }
        }
        return dp[arr.length-1][aim];
    }

}
