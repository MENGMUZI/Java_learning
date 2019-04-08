import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-03  00:50
 * @description: 最高分多少
 */
public class HighestMark {
    public static void main(String[] args) {
        int M = 0, N = 0;
        int i;
        int A = 0, B = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            N = scanner.nextInt();
            M = scanner.nextInt();
            int[] score = new int[N];
            for (int j = 0; scanner.hasNext()&& j < N ; j++) {
                score[j] = scanner.nextInt();
            }
            String c = null;
            for (int k = 0; scanner.hasNext() && k < M ; k++) {
                c = scanner.next();
                A = scanner.nextInt();
                B = scanner.nextInt();
                process(score,c,A,B);
            }
        }
    }

    private static void process(int[] score, String c, int A, int B) {
        int max = Integer.MIN_VALUE;
        int begin , end;
        if(c.equals("Q")){
            begin =  A > B ? B-1 : A-1;
            end = A > B ?  A : B;
            for (int i = begin; i < end ; i++) {
                max = max > score[i] ? max : score[i];
            }
            System.out.println(max);
        }else if(c.equals("U")){
            score[A-1] = B;
        }
    }

}
