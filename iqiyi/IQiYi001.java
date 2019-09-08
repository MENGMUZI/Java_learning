import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-08  14:56
 * @description:
 */
public class IQiYi001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[3];
        arr[0] = x - 1;
        arr[1] = y - 1;
        arr[2] = z - 1;
        Arrays.sort(arr);
        if (arr[0] == 0 && arr[1] == 0) {
            System.out.println(arr[2] + 1);
        }
        if (arr[0] == 0 && arr[1] == 1) {
            System.out.println((arr[2] + 1) * 2);
        }
        if (arr[0] == 0 && arr[1] >= 1) {
            System.out.println((arr[2] + 1) * (arr[1] + 1));
        }
        if (arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1) {
            System.out.println((arr[2] + 1) * (arr[1] + 1)*(arr[0] +1));

        }
    }

}
