import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-07-07  15:34
 * @description:
 */
public class ByteDance03 {

    public static void main(String[] args) {
        int ans=0;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();//吃饭人数
        int maxHeigh = scanner.nextInt();//相邻高度
        boolean[] flag = new boolean[number];
        int[] h = new int [number];

        for (int i = 0; i <number ; i++) {
            h[i] = scanner.nextInt();
        }

        for (int i = 0; i <number ; i++) {
            flag[i] = true;
        }
        flag[0] = false;

        find(1,0,0,number,maxHeigh,h,flag,ans);
        System.out.println(ans);


    }

    public  static void find(int indexnow , int pre ,int first ,int number ,int maxHeigh ,int[] h, boolean[] flag, int ans){
        if(number == indexnow){
            if(Math.abs(h[pre]-h[first]) <= maxHeigh){
                ans++;

            }
            for (int i = 1; i < number; i++) {
                if(flag[i] && Math.abs(h[i]-h[pre]) <= maxHeigh){
                    flag[i] = false;
                    find(indexnow+1,i,first,number,maxHeigh,h,flag,ans);
                    flag[i] = true;
                }
            }
        }
    }

}
