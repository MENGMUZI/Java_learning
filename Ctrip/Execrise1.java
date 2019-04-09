import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  18:46
 * @description: 机试第一题
 */
public class Execrise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            boolean flag = false;
            Set<String> set = new HashSet<>();
            String node = scanner.nextLine();
            String[] arr = node.split(",");
            for (int i = 0; i <arr.length ; i++) {
                if(!set.add(arr[i])){
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);

        }
    }

}
