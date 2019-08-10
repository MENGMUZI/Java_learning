import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  19:32
 * @description:
 */
public class ShellTest03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num ; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int curr;//当前的体重
        int count = 0;//比赛的场数
        int index = 0;//前一次的场数
        for (int i = 0; i < num ; i++) {
            curr = arr[i];
            for (int j = i+1; j <num ; j++) {
                if(curr >= (0.9*arr[j])){
                    count ++;
                }else{
                    break;
                }
            }
        }
        System.out.println(count);
    }

}
