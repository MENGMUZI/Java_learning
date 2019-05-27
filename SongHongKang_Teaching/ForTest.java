import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-05-21  16:16
 * @description: 最大公约数和最小公倍数
 */
public class ForTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入第一个正整数：");
        int m = scan.nextInt();
        System.out.println("输入第二个正整数：");
        int n = scan.nextInt();
        //获取两个数的较小值
        int min = (m <= n)? m : n;
        for(int i = min; i >=1 ; i--){
            if(m % i ==0 && n % i == 0){
                System.out.println("最大化公约数为："+ i);
                break;
            }
        }
        //获取两个数的较大值
        int max = ( m >= n)? m : n;
        for (int i = max; i <= m * n ; i++) {
            if(i % m ==0 && i % n ==0){
                System.out.println("最小公倍数为："+ i);
                break;
            }
        }

    }

}
