import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-11  20:38
 * @description:
 */
public class WB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            if(m < n){
                System.out.println((n*k)/m);
            }else{
                System.out.println(n*k/m + (n*k)% m);
            }


        }

    }

}
