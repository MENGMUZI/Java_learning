import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author : mengmuzi
 * create at:  2019-04-02  22:16
 * @description: 明明的随机数
 */
public class RandomNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            TreeSet<Integer> treeSet= new TreeSet<>();
            if(num > 0){
                for (int i = 0; i <num ; i++) {
                    treeSet.add(scanner.nextInt());
                }
            }
            for(Integer t:treeSet){
                System.out.println(t);
            }
        }
    }

}
