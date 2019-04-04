import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-04-04  10:34
 * @description: 贪吃小q
 */
public class WantEatQ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first=0;
        while(scanner.hasNext()){
            int N = scanner.nextInt();//出差N天
            int M = scanner.nextInt();//留下M块巧克力
            //通过二分法找到第一天的块数
            int begin = 1;
            int end = M;
            first = binarySearch(begin,end,N,M);
            System.out.println(first);
        }
        //System.out.println(first);

    }

    private static int binarySearch(int begin, int end, int day,int colo) {
        int mid = 0;
        while(begin <= end){
            mid = begin + ((end - begin)>>1);
            if(allSum(mid,day) >colo ){
                end = mid-1;
            }else if(allSum(mid,day) < colo){
                begin = mid+1;
            }else{
                return mid;
            }
        }
        return end;//注意二分法这边的边界
    }

    private static int allSum(int mid,int day) {
        int sum = 0;
        for (int i = 0; i <day ; i++) {
            sum +=mid;
            mid = (int)Math.ceil(mid/2.0);
        }
        return sum;
    }
}
