import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  15:04
 * @description:
 */
public class PinDuoDuoTest01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number ; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        List<Double> list = new ArrayList<>();
        for (int i = 0; i <number-2 ; i++) {
            double one = arr[i];
            double two = arr[i+1];
            double three = arr[i+2];
            double avg = (one + two + three)/3;
            double fangCha = (Math.pow((one-avg),2) + Math.pow((two-avg),2) +Math.pow((three-avg),2))/3;
            list.add(fangCha);
        }
        double min = list.get(0);
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        System.out.printf(String.format("%.2f",min));
    }

}
