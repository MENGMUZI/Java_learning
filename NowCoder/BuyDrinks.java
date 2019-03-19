import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-03-19  20:05
 * @description: 华为汽水瓶
 */
public class BuyDrinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int blank = scanner.nextInt();//空瓶的数目
            int res = 0;//喝的总瓶数
            while(blank >= 3){
                int nums1 = blank / 3;
                int nums2 = blank % 3;
                res += nums1;
                blank = nums1 + nums2;
            }
            if(blank == 2){
                res ++;
            }
            System.out.println(res);
        }

    }

}
