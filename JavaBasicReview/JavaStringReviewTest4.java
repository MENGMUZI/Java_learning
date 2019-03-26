/**
 * @author : mengmuzi
 * create at:  2019-03-26  21:53
 * @description: 模拟一个字符串的trim的功能
 */
public class JavaStringReviewTest4 {

    public static void main(String[] args) {
        String s = "  meng mu zi  ";
        String res = myTrim(s);
        System.out.println(res);
    }
    private static String myTrim(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end && s.charAt(start) == ' '){
            start++;
        }
        while(start <= end && s.charAt(end) == ' '){
            end--;
        }
        String sub = s.substring(start,end+1);
        return sub;
    }

}
