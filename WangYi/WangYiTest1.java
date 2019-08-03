import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-03  14:45
 * @description:
 */
public class WangYiTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();//班级总人数
        int[] arr = new int[number];
        for (int i = 0; i < number ; i++) {
            arr[i] = scanner.nextInt();
        }
        int query = scanner.nextInt();
        int[] queryArr = new int[query];
        for (int i = 0; i < query; i++) {
            queryArr[i] = scanner.nextInt();
        }
        double[] result = new double[number];
        for (int i = 0; i <number ; i++) {
            int score = arr[i];//分数
            double count = 0;
            for (int j = 0; j < number ; j++) {
                if(arr[j] <= score ){
                    count ++;
                }
            }
            double number1 = (double) number;
            result[i] = (count - 1)/number1 * 100;
        }
        for (int i = 0; i < query ; i++) {
            //System.out.println(result[queryArr[i] - 1]);
            System.out.println(String.format("%.6f",result[queryArr[i] - 1]));
        }


    }




}
