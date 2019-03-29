import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-03-29  16:57
 * @description: ReentrantLock的实现
 */
public class ReentrantLockReviewDemo {

    private Lock lock = new ReentrantLock();
    public void function(){
        lock.lock();
        try{
            for (int i = 0; i <10 ; i++) {
                System.out.print(i +" ");
            }
        }finally{
            lock.unlock();// 确保释放锁，从而避免发生死锁。
        }
    }

    public static void main(String[] args) {
        ReentrantLockReviewDemo rl = new ReentrantLockReviewDemo();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> rl.function());
        es.execute(() -> rl.function());
    }

}
