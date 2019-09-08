/**
 * @author : mengmuzi
 * create at:  2019-09-05  19:36
 * @description: 最大奇约数的和
 */
public class HelloBycle001 {
    /**
     * 1.所有的奇数的最大奇约数就是奇数本身
     * 2.若是偶数f(2) + f(4) + f(6) + ... + f(2k) = f(1) + f(2) +...+ f(k);
     * 3.sum(n) = sum (n / 2) + 1 + 3 + ... + n - 1 = sum (n/2) + n*n/4（n 为偶数）
     * = sum (n - 1) + n （n为奇数）
     */

    private static int maxOddApproximationSum(int N) {
        if (N == 1) {
            return 1;
        }
        if (N % 2 == 0) {
            return maxOddApproximationSum(N / 2) + N * N / 4;
        }else{
            return maxOddApproximationSum(N-1) + N;
        }

    }

    public static void main(String[] args) {
        int rst = maxOddApproximationSum(7);
        System.out.println(rst);
    }
}
