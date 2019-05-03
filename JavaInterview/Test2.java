/**
 * @author : mengmuzi
 * create at:  2019-05-03  16:46
 * @description:
 */
public class Test2 {
    public static void main(String[] args) {
        char[] ch = {'H','E','L','L','O'};
        change(ch);
        System.out.println(ch);
    }

    private static void change(char[] ch) {
        ch[0] = 'C';
    }

}
