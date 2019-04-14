import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-14  20:21
 * @description:
 */
public class XXCC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        while(scanner.hasNext()) {
            queue.offer(scanner.nextInt());
            if(scanner.next()=="#"){
                break;
            }
        }
        int count  = 1;
        while(queue.size() > 1) {
            for (int i = 0; i <count ; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            count++;
        }
        System.out.println(queue.poll());


    }

}
