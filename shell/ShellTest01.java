import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  18:52
 * @description:
 */
public class ShellTest01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long[] arr = new long[number];
        for (int i = 0; i <number ; i++) {
            arr[i] = scanner.nextLong();
        }
        long[] arrA = new long[number-1];
        for (int i = 0; i <number -1 ; i++) {
            arrA[i] = Math.abs(arr[i] - arr[i+1]);
        }
        //找元素中最小的值
        long min = arrA[0];
        int index = 0;
        for (int i = 0; i <number -1 ; i++) {
            if(arrA[i] < min){
                min = arrA[i];
                index = i;
            }
        }
        System.out.print(arr[index]);
        System.out.print(arr[index+1]);

    }

}
