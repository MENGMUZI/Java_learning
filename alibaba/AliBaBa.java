/**
 * @author : mengmuzi
 * create at:  2019-08-30  18:58
 * @description:
 */
import java.util.Scanner;

public class AliBaBa {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users) {

        int boyFirst = users.indexOf('b');

        int boySecond = users.indexOf('b',boyFirst);
        int flag = boySecond;
        int boyThrid = users.indexOf('b',boySecond);
        int max = boyThrid-boyFirst-2;
        int len = users.length();
        for (int i = boyFirst; i <=boyThrid ; i++) {
            if (users.charAt(i) == 'b') {
                boyFirst = i;
                boySecond = users.indexOf('b',boyFirst);
                boyThrid = users.indexOf('b',boySecond);
                if(boyThrid-boyFirst-2 > max){
                    max =  boyThrid-boyFirst-2;
                    flag = boySecond;
                }
            }

        }
        return null;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users);
        System.out.println(res);
    }
}