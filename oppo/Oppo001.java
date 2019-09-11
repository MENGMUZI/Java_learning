import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-08  18:58
 * @description:
 */
public class Oppo001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String s = scanner.next();
        int result = longestSubString(s, k);
        System.out.println(result);


    }

    private static int longestSubString(String s, int k) {
        int result = 0;
        int leftPoint = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int rightPoint = 0;
        for (rightPoint = 0; rightPoint < s.length(); rightPoint++) {
            hashMap.put(s.charAt(rightPoint), rightPoint);
            while (hashMap.size() > k) {
                char leftChar = s.charAt(leftPoint);
                if(hashMap.get(leftChar) == leftPoint){
                    hashMap.remove(leftChar);
                }
                leftPoint++;
            }
            int subRet = rightPoint - leftPoint +1 ;
            result = Math.max(result,subRet);
        }
        return result;


    }

}
