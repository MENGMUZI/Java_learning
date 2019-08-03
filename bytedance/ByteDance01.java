import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-07-07  13:51
 * @description:
 */
public class ByteDance01 {

    public static void main(String[] args) {
        int point = 0;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        List<Integer> myList = new ArrayList<>();
        List<Integer> otherList = new ArrayList<>();
        for (int i = 0; i <number ; i++) {
            myList.add(scanner.nextInt());
        }
        for (int i = 0; i <number ; i++) {
            otherList.add(scanner.nextInt());
        }

        Collections.sort(myList);
        Collections.sort(otherList);

        int i = 0;
        int j = 0;
        int x = number -1 ;
        int y = number -1 ;
        boolean isLast = true;
        while(isLast){
            if(x==i){
                isLast = false;
            }
            if(myList.get(x) > otherList.get(y)){
                x--;
                y--;
                point++;
            } else if(myList.get(i) > otherList.get(j)){
                i++;
                j++;
                point++;
            }else{
                if(myList.get(i) < otherList.get(y)){
                    point--;
                }
                i++;
                y--;
            }
        }

        System.out.println(point);

    }

}
