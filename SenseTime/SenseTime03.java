import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-19  20:13
 * @description:
 */
public class SenseTime03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] array = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        int result = maxProfit(array);
        System.out.println(result);

    }

    public static int maxProfit(int[] array) {
        //如果数组的元素个数空或者小于2返回0
        if (array == null || array.length < 2) {
            return 0;
        }
        //最小买入点
        int minBuy = array[0];

        //最大利润和
        int maxProfit = 0;

        for (int i = 1; i < array.length; i++) {
            //如果min后面的某个值，获得的利润更大，就成为新的买入点
            if ((array[i] - minBuy > maxProfit)) {
                maxProfit = array[i] - minBuy;
            }
            //如果出现比买点更小的值，就将min付给它；
            minBuy = array[i] < minBuy ?  array[i] : minBuy;
        }
        return maxProfit;
    }

}
