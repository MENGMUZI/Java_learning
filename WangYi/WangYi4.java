import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-03  16:31
 * @description:
 */
public class WangYi4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int[] pArr = new int[p];
        for (int i = 0; i < p; i++) {
            pArr[i] = scanner.nextInt();
        }
        for (int i = 0; i < p; i++) {
            int count = 0;
            for (int j = n-1; j >=0; j--) {
                if (arr[j] >= pArr[i]) {
                    arr[j]--;
                    count++;
                }else{
                    break;
                }
            }
            System.out.println(count);
        }
    }

}
