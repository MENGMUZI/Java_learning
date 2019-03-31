import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  16:56
 * @description: 使用 BlockingQueue 实现生产者消费者问题
 */
public class ProducerConsumerBlockingQueueDemo {

    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

    private static class Producer extends Thread{
        @Override
        public void run(){
            try{
                blockingQueue.put("product");
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("produce .......");
        }
    }
    private static class Consumer extends Thread{
        @Override
        public void run(){
            try{
                String product = blockingQueue.take();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("consume......");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for (int i = 0; i <20 ; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i <1; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }

}
