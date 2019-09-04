/**
 * @author : mengmuzi
 * create at:  2019-09-04  20:37
 * @description:
 */

import java.util.Scanner;

public class Trip003 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int sumTime = 0;
        int maxTime = 0;
        int len = array.length;
        int[] copyArr = array;
        for (int i = 0; i < len; i++) {
            sumTime += copyArr[i];
            maxTime = Math.max(sumTime, copyArr[i]);
        }
        if (m == 1) {
            return sumTime;
        }
        if (len == m) {
            return maxTime;
        }

        int left = maxTime;
        int right = sumTime;
        int mid = 0;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            int now = copyArr[0];
            int help = 1;
            for (int i = 1; i < len; i++) {
                now += copyArr[i];
                if (now > mid) {
                    help++;
                    now = copyArr[i];

                }
            }
            if (help > mid) {
                left = mid;

            }else{
                right = mid;
            }
        }
        int now = copyArr[0];
        int help = 1;
        for (int i = 1; i < len ; i++) {
            now +=copyArr[i];
            if(now >left){
               help++;
               now = copyArr[i];
            }
        }
        if(help <= m){
            return left;
        }else {
            return right;
        }


    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}

