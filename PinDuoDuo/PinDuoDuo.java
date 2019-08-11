import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  15:49
 * @description:
 */
public class PinDuoDuo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length - 1];
        int dif = max - min;
        int mid = 0;
        if (dif < length / 2) {
            mid = (int) Math.ceil((min + max) / 2 );
        } else {
            mid = (int) ((Math.ceil((min + length + max) / 2)) % length);
        }
        mid = (min + max) / 2 ;
        int lessMid = 0;
        int equals = 0;
        int moreMid = 0;
        for (int i = 0; i < number; i++) {
            if (arr[i] == mid) {
                equals++;
            } else if (arr[i] < mid) {
                lessMid++;
            } else {
                moreMid++;
            }
        }
        int result = 0;
        for (int i = 0; i < number; i++) {
            result += Math.abs(arr[i] - mid);
        }
        if (equals == 0) {
            result = result - add(moreMid) - add(lessMid);
        } else {
            result = result - add(moreMid) - add(lessMid);
        }
        System.out.println(result);

    }

    private static int add(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + i + 1;
        }
        return sum;
    }

}
