import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-31  16:53
 * @description:
 */
public class Test360_001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int maxCount = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char element : str.toCharArray()){
            Integer i = map.get(element);
            int value = (i == null)? 0:i;
            map.put(element,++value);
            maxCount = value > maxCount ? value : maxCount;
        }
        System.out.println(maxCount);
    }

}
