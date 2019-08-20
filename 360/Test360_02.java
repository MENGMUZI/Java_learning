import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-15  20:46
 * @description:
 */
public class Test360_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//数的位数
        int m = scanner.nextInt();//进制
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < n ; i++) {
            sb1.append(scanner.nextInt());
        }
        for (int i = 0; i < n ; i++) {
            sb2.append(scanner.nextInt());
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = m-1; i >=0 ; i--) {
            for (int j = i; j >=0 ; j--) {
                list1.add(j);
                list2.add(i-j);
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i <list1.size() ; i++) {
            if(sb1.indexOf(String.valueOf(list1.get(i))) != -1 && sb2.indexOf(String.valueOf(list2.get(i)))!= -1){

            }
        }




    }

}
