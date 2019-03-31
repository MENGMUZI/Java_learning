import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  15:30
 * @description: CyclicBarrier  用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
 */
public class CyclicRarrierReviewDemo {

    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <totalThread ; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread()+"before........");
                try{
                   cyclicBarrier.await();
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"after。。。。。。。。");
            });
        }
        executorService.shutdown();
    }

}
