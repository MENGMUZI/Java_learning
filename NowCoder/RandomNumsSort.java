
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author : mengmuzi
 * create at:  2019-03-19  20:30
 * @description: 随机数排序
 */

public class RandomNumsSort {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            TreeSet<Integer> ts = new TreeSet<Integer>();
            int n = scan.nextInt();
            for (int i = 0; i < n ; i++) {
                ts.add(scan.nextInt());
            }
            Iterator<Integer> iterator = ts.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());;
            }

        }
    }

}
