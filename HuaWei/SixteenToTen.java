import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-02  22:40
 * @description: 16进制的字符串转成10进制
 */
public class SixteenToTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(Integer.parseInt(str.substring(2),16));
        }

    }

}
