import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-04  09:43
 * @description: 翻转数列
 */
public class ReverseArray {

    public static void main(String[] args) {
        long n,m;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            n = scanner.nextInt();
            m = scanner.nextInt();
            long group = n / (2*m);
            long sum = m*m*group;
            System.out.println(sum);
        }
    }

}
