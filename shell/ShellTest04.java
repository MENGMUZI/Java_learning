import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  20:34
 * @description:
 */
public class ShellTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        int start = 0;//头指针
        int end = num - 1;//尾指针
        int result = 0;

        while(start <= end){
            if(arr[start] <= arr[end]){
                if(arr[start+1] <= arr[start]){
                    arr[start+1] = arr[start] + 1;
                    result += arr[start+1]-arr[start];
                }
                start ++;
            }else{
                if(arr[end-1] <= arr[end]){
                    arr[end-1] = arr[end] + 1;
                    result += arr[end-1] - arr[end];
                }
                end --;

            }

        }
        System.out.println(result);
    }

}
