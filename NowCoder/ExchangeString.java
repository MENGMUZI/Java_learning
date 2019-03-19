import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-03-19  20:57
 * @description:
 */
public class ExchangeString {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext()){
                String str = scan.next().substring(2);
                System.out.println(Integer.parseInt(str,16));

            }
        }


}
