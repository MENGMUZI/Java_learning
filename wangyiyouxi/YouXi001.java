import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-07  18:53
 * @description:
 */
public class YouXi001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times ; i++) {
            int nums = scanner.nextInt();
            String s = Integer.toBinaryString(nums);
            StringBuffer sb = new StringBuffer(s);
            StringBuffer sbCopy = new StringBuffer(s);
            sbCopy.reverse();
            if(sb.toString().equals(sbCopy.toString())){
                System.out.println("YES");
            }else {
                System.out.println("NO");

            }
        }
    }

}
