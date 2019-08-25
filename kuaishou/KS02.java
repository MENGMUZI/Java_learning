import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-08-25  17:20
 * @description:
 */
public class KS02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < group ; i++) {
            list.add(scanner.next());
        }
        for (int i = 0; i < group ; i++) {
            Set<Integer> hashSet = new HashSet<>();
            String cur = list.get(i);
            int squSum = 0;
            //int memo = 0;
            while(true){
                for (int j = 0; j < cur.length() ; j++) {
                    //计算各位的平方和
                    int curNum = Integer.valueOf(cur.charAt(j)) - 48;
                    squSum += Math.pow(curNum,2);
                }
                if(hashSet.contains(squSum)){
                    System.out.println("false");
                    break;
                }
                hashSet.add(squSum);
                cur = String.valueOf(squSum);
                squSum = 0;

                if(hashSet.contains(1)) {
                    System.out.println("true");
                    break;
                }

            }



        }

    }

}
