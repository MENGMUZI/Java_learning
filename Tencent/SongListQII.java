import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-04  23:35
 * @description: 小Q的歌单
 * 【题目描述】 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
 * 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法
 * 输入描述：
 * 每个输入包含一个测试用例
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K（1<=K<=1000）
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * 输出描述：
 * 输出一个整数，表示组成歌单的方法取模。因为答案可能会很大，输出对1000000007取模的结果.
 * */

public class SongListQII {
    static long mod = 1000000007;
    public static long[][] arr = new long[101][101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int targetLen = scanner.nextInt();
            int firstLen = scanner.nextInt();
            int firstNum = scanner.nextInt();
            int secondLen = scanner.nextInt();
            int secondNum = scanner.nextInt();
            initialArr(arr);
            int ans = caculate(targetLen,firstLen,firstNum,secondLen,secondNum);
            System.out.println(ans);
        }


    }

    private static int caculate(int targetLen, int firstLen, int firstNum, int secondLen, int secondNum) {
        int res = 0;
        for (int i = 0; i <firstNum ; i++) {
            if(firstLen * i <= targetLen && (targetLen-firstLen * i) % secondLen == 0 && (targetLen - firstLen * i)/secondLen <=secondNum ){
                long temp = arr[firstNum][i] * arr[secondNum][(targetLen - firstLen * i)/secondLen];
                res = (int)((res + temp)% mod);
            }
        }
        return res;

    }

    //计算组合数C(n,k) = C(n-1,k) + C(n-1,k-1）
    private static void initialArr(long[][] arr) {
        arr[0][0] = 1;
        for (int i = 1; i <101 ; i++) {
            arr[i][0] = 1;
            for (int j = 1; j <=i ; j++) {
                arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % mod;
            }
        }
    }


}
