import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-07-07  14:46
 * @description:
 */
public class ByteDance02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lovePoint = 0;//最大喜欢值
        int point = scanner.nextInt();//n
        int number = scanner.nextInt();//m
        List<Integer> allList = new ArrayList<>();
        for (int i = 0; i < (2*number) ; i++) {
            allList.add(scanner.nextInt());
        }
        //w数组为喜爱值
        List<Integer> likeList = new ArrayList<>();
        //c数组为消耗积分
        List<Integer> pointList = new ArrayList<>();


        for (int i = 0; i <allList.size() ; i++) {
            if(i%2 == 0){
                pointList.add(allList.get(i));
            }else{
                likeList.add(allList.get(i));
            }
        }

        int sum = 0;
        for (int i = 0; i <number ; i++) {
            if(pointList.get(i) <= point){
                sum += pointList.get(i);
            }
        }

        if(sum < point){
            point = sum;
        }

        int[] f0 = new int[point+1];
        for (int i = 0; i <point; i++) {
            f0[i] = 0;
        }
        int[] f1 = new int[point+1];

        for (int i = 0; i <number ; i++) {
            for (int j = pointList.get(i); j <=point ; j++) {
                f1[j] = Math.max(f0[j-pointList.get(i)]+likeList.get(i),f0[j]);
            }
            for (int j = 0; j <=point ; j++) {
                f0[j] = f1[j];
            }
        }
        System.out.println(f1[point]);


    }

}
