import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-05  20:27
 * @description:
 */
public class Execrise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int len = scanner.nextInt();
            String str = scanner.next();
            String key1 = "10";
            String key2 = "01";
            while(str.contains(key1) || str.contains(key2)){
                int index1 = str.indexOf(key1);
                int index2 = str.indexOf(key2);
                int index = 0;
                if(index1 != -1 && index2 != -1){
                    index = index1 > index2 ? index2 : index1;
                }
                if(index1 == -1 && index2 == -1){
                    break;
                }
                if(index1 == -1 && index2 != -1){
                    index = index2;
                }
                if(index2== -1 && index1 != -1){
                    index = index1;
                }
                if(index == 0){
                    str = str.substring(index +2);
                }else{
                    str = str.substring(0,index) + str.substring(index+2);
                }

            }
            int result = str.length();
            System.out.println(result);

        }
    }


}
