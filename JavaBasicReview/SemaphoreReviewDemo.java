import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  15:45
 * @description: Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
 */
public class SemaphoreReviewDemo {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < totalRequestCount; i++){
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    System.out.println(semaphore.availablePermits());
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }

}
