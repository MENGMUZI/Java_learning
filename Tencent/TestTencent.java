/**
 * @author : mengmuzi
 * create at:  2019-04-05  01:37
 * @description: 测试
 */
public class TestTencent {

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");

        for (int i = 0, j = 0; i < 10 ; i++) {
            for (; j <=i  ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }


}
