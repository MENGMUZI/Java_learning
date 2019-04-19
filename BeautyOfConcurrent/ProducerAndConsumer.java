import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : mengmuzi
 * create at:  2019-04-19  10:35
 * @description: 生产者消费者
 */
public class ProducerAndConsumer{
    private final static int MAX_Size = 10;
    private static Queue<String> queue = new LinkedList<>();
    private String element;

    public class Producer extends Thread{
        @Override
        public void run(){
            synchronized (queue){
                while(queue.size() == MAX_Size){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //空闲则生成元素，并唤醒消费者
                queue.add(element);
                queue.notifyAll();
            }
        }
    }

    public class Consumer extends Thread{
        @Override
        public void run(){
            synchronized (queue){
                while(queue.isEmpty()){
                    try{
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();
                queue.notifyAll();
            }
        }
    }


}
