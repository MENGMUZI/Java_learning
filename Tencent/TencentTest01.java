import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-01  19:59
 * @description:
 */
public class TencentTest01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] aArr = new int[n];
        int[] bArr = new int[m];

        int aIsEven = 0;
        int bIsEven = 0;
        int aIsOdd = 0;
        int bIsOdd = 0;

        for (int i = 0; i < n ; i++) {
            aArr[i] = scanner.nextInt();
            if(aArr[i] % 2 == 0){
                aIsEven ++;
            }else {
                aIsOdd ++;
            }
        }

        for (int i = 0; i < m ; i++) {
            bArr[i] = scanner.nextInt();
            if(bArr[i] % 2 == 0){
                bIsEven ++;
            }else{
                bIsOdd ++;
            }
        }
        System.out.println(Math.min(aIsEven,bIsOdd) + Math.min(aIsOdd,bIsEven));

    }

}
