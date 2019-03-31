import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  01:25
 * @description: 多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。
 */
public class ThreadUnsafeReviewDemo {

    static class ThreadUnsafe{
        private int cnt = 0;
        public void add(){
            cnt ++ ;
        }
        public int get(){
            return cnt;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafe threadUnsafe = new ThreadUnsafe();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <threadSize ; i++) {
            executorService.execute(()->{
                threadUnsafe.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(threadUnsafe.get());
    }

}
