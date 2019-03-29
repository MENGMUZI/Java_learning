import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-03-29  19:38
 * @description: ReentrantLock中的tryLock方法
 */
public class LockReviewTest2 {

    private Lock lock = new ReentrantLock();
    public void tryLockMethod(Thread thread){
        if(lock.tryLock()){
            try{
                System.out.println("线程名" + thread.getName() + "获得当前锁");
                System.out.println("我是线程" + thread.getName() + "我正在工作》》》》》");
                Thread.sleep(5000);
            }catch(Exception e){
                System.out.println("线程名" + thread.getName() + "发生了异常释放锁");
            }finally{
                System.out.println("线程名" + thread.getName() + "执行完毕释放锁");
                lock.unlock();
            }
        }else{
            System.out.println("我是线程"+Thread.currentThread().getName()+"当前锁被别人占用，我无法获取");
        }
    }

    public static void main(String[] args) {
        LockReviewTest2 le = new LockReviewTest2();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                le.tryLockMethod(Thread.currentThread());
            }
        },"thread1");
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                le.tryLockMethod(Thread.currentThread());
            }
        },"thread2");
        th1.start();
        th2.start();
    }

}
