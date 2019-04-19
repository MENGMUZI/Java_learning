import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-04-19  15:05
 * @description: 线程在睡眠时拥有的监视器资源不会被释放。
 */
public class ThreadSleepDemo {

    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try{
                    System.out.println("child threadA is in sleep");
                    Thread.sleep(1000);
                    System.out.println("child threadA is in awake");
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        //创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //获得独占锁
                lock.lock();
                try{
                    System.out.println("child threadB is in sleep!");
                    Thread.sleep(1000);
                    System.out.println("child threadB is in awake!");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start();
    }

}
