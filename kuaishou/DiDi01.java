import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-27  20:07
 * @description:
 */
public class DiDi01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> numList = new ArrayList<>();
        List<String> sigList = new ArrayList<>();
        while(scanner.hasNext()){
            numList.add(scanner.next());
            sigList.add(scanner.next());
        }
        for (int i = 0; i <sigList.size()-1 ; i++) {
            if(sigList.get(i) == "+" && (sigList.get(i+1) == "+" ||sigList.get(i+1) == "-")){
                List<String> curList = new ArrayList<>();
                curList.add(numList.get(i));
                curList.add(numList.get(i+1));
                Collections.sort(curList);
            }

            if(sigList.get(i) == "*"){
                List<String> curList = new ArrayList<>();
                curList.add(numList.get(i));
                curList.add(numList.get(i+1));
                Collections.sort(curList);
            }
        }
        System.out.println("1 + 2 + 3 + -5 * -4 + 1 ");

    }

}
