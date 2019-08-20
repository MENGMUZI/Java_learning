import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-19  19:51
 * @description:
 */
public class SenseTime02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arrStr = str.split(" ");
        //目标单词
        String s = arrStr[0];
        //待切分的字典
        String dic = arrStr[1];
        String[] dicArr = dic.split(",");
        List<String> list = Arrays.asList(dicArr);
        boolean result = wordDict(s,list);
        System.out.println(result);


    }

    private static boolean wordDict(String s ,List<String> list){
        int length = s.length();

        //判断某个下标之前，是否可以在字典中找到单词拼成
        boolean[] flags = new boolean[length + 1];
        flags[0] = true;

        for (int i = 1; i <= length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(flags[j] == true && list.contains(s.substring(j,i))){
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[length];
    }
}
