import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-04  17:03
 * @description: 小Q的歌单（只通过百分之四十）
 */

public class SongListQ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int songListLen = scanner.nextInt();
            int lenA = scanner.nextInt();
            int numA = scanner.nextInt();
            int lenB = scanner.nextInt();
            int numB = scanner.nextInt();
            if(lenA == lenB || numA == 0 ){
                return;
            }
            int ADivsong = songListLen/lenA;
            int mostA = ADivsong > numA ? numA : ADivsong;
            int indexA = 0;
            int indexB = 0;
            long result = 0;
            for (indexA = 0; indexA < mostA ; indexA++) {
                indexB = (songListLen-indexA*lenA) / lenB;
                if((songListLen-indexA*lenA)%lenB == 0 && indexB <= numB) {
                    long CA = factorial(numA) / (factorial(indexA) * factorial(numA - indexA));
                    long CB = factorial(numB) / (factorial(indexB) * factorial(numB - indexB));
                    result += (CA * CB) % 1000000007;
                }
            }
            System.out.println(result);
        }
    }
    private static long factorial(int x){
        if (x == 0) {
            return 1;
        }
        return factorial(x-1)* x;
    }

}
