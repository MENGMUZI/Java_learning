/**
 * @author : mengmuzi
 * create at:  2019-05-21  15:28
 * @description: 分支结构SwitchCase
 */
/**
 * 注意点： 直到遇到break关键字才会结束
 *
 * */
public class SwitchCaseTest {
    public static void main(String[] args) {
        int number = 2;
        switch (number){
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("other");
        }
    }

}
