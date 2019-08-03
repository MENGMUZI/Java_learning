import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-03  16:15
 * @description:
 */
public class WangYi2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        for (int i = 0; i <  testNum; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n ; j++) {
                arr[j] = scanner.nextInt();
            }
            Arrays.sort(arr);
            if(n <= 2){
                break;
            }
            int first = arr[0];
            int last1= arr[n-1];
            int last2 = arr[n-2];
            int last3 = arr[n-3];
            if(first + last2 > last1){
                System.out.println("YES");
            }else if(last3 + last2 > last1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }


    }

}
