import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-01  21:32
 * @description:
 */
public class TXXX0003 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i <number ; i++) {
            arr[i] = scanner.nextInt();
        }
        int dpminLast = arr[0],dpminNow = arr[0];
        int dpsumLast = arr[0],dpsumNow = arr[0];
        int temp = dpminNow * dpsumNow;
        for (int i = 0; i < arr.length ; i++) {
            dpminLast = arr[i];
            dpsumLast = arr[i];
            if(temp < arr[i]*arr[i]){
                temp = arr[i]*arr[i];
            }
            for (int j = i+1; j < arr.length; j++) {
                dpminNow = arr[j] < dpminLast ? arr[j] :dpminLast;
                dpsumNow = arr[j] + dpsumLast;
                if(temp < dpminNow * dpsumNow){
                    temp = dpminNow * dpsumNow;
                }
                dpminLast = dpminNow;
                dpsumLast = dpsumNow;
            }
        }
        System.out.println(temp);

    }

}
