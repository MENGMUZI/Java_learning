import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-20  19:56
 * @description:
 */
public class Bilibili02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArr = str.split(",");
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        if(strArr[0].equals("0")){
            return;
        }
        String result = new String();
        for (int i = 0; i < strArr.length; i++) {
            result += strArr[i];
        }
        System.out.println(result);


    }


}
