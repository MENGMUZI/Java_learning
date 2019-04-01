import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  09:34
 * @description: 使用 AtomicInteger 重写之前线程不安全的代码之后得到以下线程安全实现
 */
public class AtomicReviewDemo {

    static class AtomicExample{
        private AtomicInteger cnt = new AtomicInteger();
        public void add(){
            cnt.incrementAndGet();
        }
        public int get(){
            return cnt.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        AtomicExample atomicExample = new AtomicExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <threadSize ; i++) {
            executorService.execute(()->{
                atomicExample.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(atomicExample.get());
    }

}
