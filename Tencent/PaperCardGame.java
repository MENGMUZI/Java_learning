import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-04  09:59
 * @description: 纸牌游戏
 */
public class PaperCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nums = scanner.nextInt();
            int[] arrs = new int[nums];
            for (int i = 0; i <arrs.length ; i++) {
                arrs[i] = scanner.nextInt();
            }
            Arrays.sort(arrs);
            int niuSum = 0;
            int yangSum = 0;
            boolean flag = true;
            for (int i = arrs.length-1; i >=0 ; i--) {
                if(flag){
                    niuSum += arrs[i];
                    flag = false;
                }else{
                    yangSum += arrs[i];
                    flag = true;
                }
            }
            int result = niuSum - yangSum;
            System.out.println(result);
        }

    }
}
