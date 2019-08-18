import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  15:57
 * @description:
 */
public class RedBook3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i <number; i++) {
            arr[i] = scanner.nextInt();
        }
        //创建一个辅助的数组
        int[] helpArr = new int[number];
        //其中的值表示从原始数组起始位置开始到当前下标截止的和最大值
        helpArr[0] = arr[0];
        helpArr[1] = arr[1];

        int[] addArr = new int[number];
        addArr[0] = 1;
        addArr[1] = 1;
        int curMaxVal = helpArr[0];//当前位置的最大值
        if(helpArr[1] > helpArr[0]){
            curMaxVal = helpArr[1];
        }
        int count = 1;
        //从第三个开始遍历数组

        for (int i = 2; i < arr.length; i++) {
            int val = arr[i];
            boolean flag = false;
            for (int j = 0; j < i -1 ; j++) {
                //当前值和前面的值相加与前面最大的值比较
                if(val + helpArr[j] > curMaxVal){
                    curMaxVal = val + helpArr[j];
                    addArr[i] = addArr[j] + 1;
                    flag = true;
                }
                if(!flag){
                    addArr[i] = addArr[i-1];
                }
                helpArr[i] = curMaxVal;
            }

        }
        System.out.print(curMaxVal);
        System.out.print(" ");
        System.out.print(addArr[number-1]);


    }

}
