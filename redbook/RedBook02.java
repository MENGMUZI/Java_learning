import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  15:39
 * @description:
 */
public class RedBook02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split("\\s+");
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]);
            if(i != 0){
                System.out.print(" ");
            }
        }

    }

}
