import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-11  20:26
 * @description:
 */
public class WWBB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nums = scanner.nextInt();
            int[] arrs = new int[nums];
            for (int i = 0; i < arrs.length; i++) {
                arrs[i] = scanner.nextInt();
            }
            for (int i = 0; i <arrs.length ; i++) {
                int count = 0;
                while(arrs[i] != 1){
                    if((arrs[i] & 1 )== 0){
                        arrs[i] = arrs[i] / 2;

                    }else{
                        arrs[i] = arrs[i] * 3 + 1;
                    }
                    count++;
                }
                System.out.println(count);
            }

        }

    }

}
