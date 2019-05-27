import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-05-21  16:42
 * @description: 从键盘读入不确定的整数，并判断读入的正数和负数的个数，输入0的时候结束程序
 */
public class ForWhileTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int posnum = 0;
        int negnum = 0;
        while(true){
            int number = scanner.nextInt();
            if(number > 0){
                posnum++;
            }else if(number < 0){
                negnum++;
            }else{
                break;
            }
        }
        System.out.println(negnum + posnum);
    }

}
