import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  19:57
 * @description:
 */
public class HHEH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int K = scanner.nextInt();
            char[] arrs = str.toCharArray();
            StringBuffer SB = new StringBuffer();
            StringBuffer SB1 = new StringBuffer();
            for (int i = 1; i < arrs.length-1; i++) {
                SB.append(arrs[i]);
            }
            String Sb_1 = SB.toString();
            String[] arrStr = Sb_1.split(",");
            for (int i = 0; i <arrStr.length ; i++) {
                SB1.append(arrStr[i]);
            }
            String strs = SB1.toString();
            String resultStr ="";
            int len = strs.length();
            int times = len / K;
            int index = K* times;
            for (int i = 0; i < times; i++) {
                String sub = strs.substring(K * i, K * (i + 1));
                StringBuffer sb = new StringBuffer(sub);
                resultStr += sb.reverse().toString();
            }
            resultStr = resultStr + strs.substring(index);
            System.out.println(resultStr);
            System.out.print('[');
            for (int i = 0; i <resultStr.length()-1 ; i++) {
                System.out.print(resultStr.substring(i,i+1)+",");
            }
            System.out.print(resultStr.substring(resultStr.length()-1));
            System.out.print("]");

        }
    }
}
