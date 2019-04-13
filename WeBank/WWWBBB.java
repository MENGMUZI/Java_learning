import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-11  19:39
 * @description:
 */
public class WWWBBB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nums = scanner.nextInt();
            int people = scanner.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            if(nums == 1){
                System.out.println(1);
            }else{
                for (int i = 0; i <nums ; i++) {
                    list.add(i+1);
                }
                int first = 0;
                while(list.size() > 1){
                    first = (first+people-1) % list.size();
                    System.out.print(list.get(first)+" ");
                    list.remove(first);
                }
                System.out.println();
                System.out.println(list.get(0));
            }

        }

    }


}
