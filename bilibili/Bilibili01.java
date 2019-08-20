import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-20  18:59
 * @description:
 */
public class Bilibili01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arrStr = str.split(" ");
        for (int i = arrStr.length-1; i >=0 ; i--) {
            System.out.print(arrStr[i]);
            System.out.print(" ");
        }
    }

}
