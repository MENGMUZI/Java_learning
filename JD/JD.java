import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  18:56
 * @description: 京东
 */
public class JD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nums = scanner.nextInt();
            String[] arrs = new String[nums];
            for (int i = 0; i <nums ; i++) {
                arrs[i] = scanner.next();
            }
            String str = scanner.next();
            Arrays.sort(arrs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length()-o2.length();
                }
            });

            int count = 0;
            for (int i = 0; i < arrs.length ; i++ ) {
                String newstr = str;
                while(newstr.contains(arrs[i])){
                    count++;
                    int firstindex = newstr.indexOf(arrs[i]);
                    newstr = newstr.substring(firstindex+arrs[i].length());

                }
                str = str.replaceAll(arrs[i],"*");

            }
            System.out.println(count);




        }


    }

}
