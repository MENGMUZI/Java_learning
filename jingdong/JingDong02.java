import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-24  20:27
 * @description:
 */
public class JingDong02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int friend = scanner.nextInt();
        List<List<Integer>> listArr = new ArrayList<>();
        for (int i = 0; i < friend ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 2 ; j++) {
                list.add(scanner.nextInt());
            }
            listArr.add(list);
        }
        //搬出去的人数
        int res = 0;
        List<Integer> listRes = new ArrayList<>();
        while(!listArr.isEmpty()){
            //男生对应的女伴的数量
            int[] cpNum = new int[people +1];
            for (int i = 0; i < listArr.size() ; i++) {
                cpNum[listArr.get(i).get(0)] ++;
            }
            //找出男生中最多的那个关系
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < cpNum.length; i++) {
                if(max < cpNum[i]){
                    max = cpNum[i];
                }
            }

            for (int i = 0; i < listArr.size(); i++) {
                if(listArr.get(i).get(0) == max){
                    listArr.remove(i);
                    res ++;
                    listRes.add(max);
                }
            }

        }
        System.out.println(res);
        System.out.println(listRes);


    }

}
