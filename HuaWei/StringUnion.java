import java.util.HashSet;
import java.util.Scanner;


/**
 * @author : mengmuzi
 * create at:  2019-04-02  23:00
 * @description: 输入一个字符串，求出该字符串包含的字符集合
 */
public class StringUnion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String num = scanner.nextLine();
            char[] arr = num.toCharArray();
            HashSet hashSet = new HashSet();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <arr.length ; i++) {
               if(hashSet.add(arr[i])){//set集合作为一个过滤的条件
                   sb.append(arr[i]);
               }
            }
            System.out.println(sb.toString());
        }
    }

}
