import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  22:24
 * @description:
 */
public class SJDHAS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new ArrayList();
        while(scanner.hasNext()){
            String str = scanner.next();
            int nums = scanner.nextInt();
            list.add(nums);
            if(scanner.next() == "]"){
                break;
            }

        }
        System.out.println(list);

    }

}
