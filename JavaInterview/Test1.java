/**
 * @author : mengmuzi
 * create at:  2019-05-03  14:28
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {
        int j = 0;
        short s = 1;
        int num = 32;
        System.out.println(num >> 32);

        for (int i = 0; i <100 ; i++) {
            j = j++;
            //j = j+1;
        }
        System.out.println(j);
    }

}
