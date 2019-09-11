import java.util.HashSet;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-08  18:58
 * @description:
 */
public class Oppo002{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String s = scanner.next();
        long result = longestSubString(s,k);
        System.out.println(result);

    }

    private static long longestSubString(String s, int k) {
        //剩下最后K个字符或者更少的时候，最长子串就是当前长度
        if (s.length() <= k) {
            return s.length();
        }
        long result = 0;
        for (int i = 0; i < s.length() ; i++) {
            //创建一个set，仅仅存储k个不同的子串
            HashSet<Character> hashSet = new HashSet<>();
            int index = 0;
            String subStr = s.substring(i,s.length());
            while (index < subStr.length()) {
                if(hashSet.size() < k){
                    hashSet.add(subStr.charAt(index));
                }
                if(hashSet.contains(subStr.charAt(index))){
                    index ++;
                }else{
                    break;
                }

            }
            result = Math.max(result,index);
        }
        return result;


    }

}

