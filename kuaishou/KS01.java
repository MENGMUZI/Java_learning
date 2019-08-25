import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-25  16:29
 * @description:
 */
public class KS01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        while(scanner.hasNext()){
            String version1 = scanner.next();
            String version2 = scanner.next();
            boolean result = compareVersion(version1,version2);
            System.out.println(result);

        }
    }

    public static boolean compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for (int i = 0; i < Math.max(a1.length, a2.length); i++) {
            int x = (i < a1.length ? Integer.valueOf(a1[i]) : 0);
            int y = (i < a2.length ? Integer.valueOf(a2[i]) : 0);

            if (x < y) {
                return true;
            }else if(x>y){
                return false;
            }
        }
        return false;

    }

}
