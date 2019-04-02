import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-02  21:30
 * @description: 录入得到一串字符，将字符串中小于1000的最大整数，默认输入为整数
 */
public class MaxIntegerFromString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String num = sc.nextLine();
            int len = num.length();
            int[] arr = new int[len];
            if(num.length() < 3){
                System.out.println(num);
            }else{
                for (int i = 0; i <len-2 ; i++) {
                    String sub = num.substring(i,i+3);
                    arr[i] = Integer.parseInt(sub);
                }
            }
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <arr.length ; j++) {
                max = arr[j] > max? arr[j] : max;
            }
            System.out.println(max);
        }
    }



}
