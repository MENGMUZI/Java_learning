import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-20  15:42
 * @description:
 */
public class YanZan02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int minLength = 0;
        String str = scanner.next();
        String[] strArr = str.split(",");
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        for (int i = 0; i < n ; i++) {
            //整个路径的距离
            minLength= minLength + Math.abs(arr[i] - arr[Math.max(i-1,0)]);
        }
        int ignore = 0;
        for (int i = 1; i < n -1 ; i++) {
            int dest = Math.abs(arr[i-1]-arr[i]) + Math.abs(arr[i] - arr[i+1]) -Math.abs(arr[i-1] - arr[i+1]);
            ignore = Math.max(ignore,dest);
        }
        System.out.println(minLength -ignore);

    }

}
