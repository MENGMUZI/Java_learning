import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-03-25  22:25
 * @description: 删除一组数
 */
public class DeleteNumber {
    //方法一：使用ArrayList
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i <num ; i++) {
                list.add(i);
            }
            int first = 0;
            while(list.size() > 1){
                first = (first+2)%list.size();
                list.remove(first);
            }
            System.out.println(list.get(0));
        }
    }

   /* //方法二：使用Linkedlist
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i <num ; i++) {
                queue.offer(i);
            }
            while(queue.size() > 1) {
                for (int i = 0; i < 2; i++) {
                    queue.offer(queue.poll());
                }
                queue.poll();
            }
            System.out.println(queue.poll());
        }
    }*/

}
