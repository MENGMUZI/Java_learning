import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-07  20:42
 * @description:
 */
public class YouXi003 {

    static int[] ans;
    static int m, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ans = new int[t];
        for (int i = 0; i < t; i++) {
            k = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = scanner.nextInt();
            }
            cal(i);

        }
        for (int j = 0; j < t; j++) {
            System.out.println(ans[j]);
        }
    }

    private static void cal(int index) {
        k = k + 1;
        int p = 1 - k, pa = 0;
        int thisAns = 0;
        while (pa < m) {
            while (p + k <= a[pa] - k) {
                thisAns++;
                p += k;

            }
            p = a[pa];
            thisAns++;
            pa++;
        }
        if (m > 0) {
            p = a[m - 1];
        } else {
            p = 1 - k;

        }
        while (p + k <= 30) {
            thisAns++;
            p += k;
        }
        ans[index] = thisAns;
    }

}
