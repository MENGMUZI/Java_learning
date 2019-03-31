import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  15:05
 * @description: CountDownLatch  用来控制一个线程等待多个线程。
 */
public class CountDownLatchRevieweDemo {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread ; i++) {
            executorService.execute(()->{
                try{
                    System.out.println("线程"+"running>>>>>>>>");
                    countDownLatch.countDown();
                }catch(Exception e){
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }

}
