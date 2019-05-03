/**
 * @author : mengmuzi
 * create at:  2019-05-03  14:13
 * @description:
 */
public class IPlusPlus {
    static {
        int x = 3;
    }
    static int x,y;

    public static void main(String[] args) {
        x--;
        myMethod();
        System.out.println(x + y++ + x);
    }

    private static void myMethod() {
        y = x++ + ++x;
    }
}
