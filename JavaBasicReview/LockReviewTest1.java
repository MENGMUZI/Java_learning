import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-03-29  19:20
 * @description: ReentrantLock是Lock接口的实现
 */
public class LockReviewTest1 {

    private Lock lock = new ReentrantLock();
    //同步方法
    private void method(Thread thread){
        lock.lock();
        try{
            System.out.println("线程名" + thread.getName() + "获得了锁");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("线程名" + thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockReviewTest1 lrt = new LockReviewTest1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lrt.method(Thread.currentThread());
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lrt.method(Thread.currentThread());
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
