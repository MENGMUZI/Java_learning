import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-24  18:59
 * @description:
 */
public class JingDong01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] cpArr = Arrays.copyOf(arr,num);
        int[] cpArr_cnt = new int[num];
        Arrays.fill(cpArr_cnt,1);
        Arrays.sort(cpArr);

        for (int i = 1; i < num ; i++) {
            if(cpArr[i] == cpArr[i-1]){
                cpArr_cnt[i] = cpArr_cnt[i-1] + 1;
            }

        }
        int res = 0,max = 0,cnt = 0;
        for (int i = 0; i < num ; i++) {
            if(max == arr[i]){
                cnt ++;
            }else if(max < arr[i]){
                cnt = 1;
                max = arr[i];
            }
            if(max == cpArr[i] && cnt == cpArr_cnt[i]){
                res++;
            }
        }
        System.out.println(res);
    }

}
