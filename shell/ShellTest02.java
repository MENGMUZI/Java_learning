import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  20:07
 * @description:
 */
public class ShellTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[arr.length];
        int len = 0;
        for (int element : arr) {
            int i = Arrays.binarySearch(dp, 0, len, element);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = element;
            if (i == len) {
                len++;

            }
        }
        System.out.println(len);
    }

}
