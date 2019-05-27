/**
 * @author : mengmuzi
 * create at:  2019-05-21  16:52
 * @description: 9*9乘法表
 */
public class NineNineNumber {

    public static void main(String[] args) {
        for(int i = 1; i <= 9 ; i++){
            for(int j = 1; j <= i ; j++){
                System.out.print(i +"*"+ j +"="+(i*j));
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}
