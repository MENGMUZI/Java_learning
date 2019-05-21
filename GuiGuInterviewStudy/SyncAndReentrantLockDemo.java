import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author : mengmuzi
 * create at:  2019-05-12  01:32
 * @description: synchronized 和 ReentrantLock的区别？ 用新的Lock 的有什么好处？
 */

/**
 * 1. 原始构成
 *   * synchronized 是关键字属于JVM的层面
 *    反应在字节码上是 monitorenter 和 monitorexit，其底层是通过 monitor 对象来完成，
 *    其实 wait/notify 等方法也是依赖 monitor 对象只有在同步快或方法中才能调用 wait/notify 等方法。
 *   * Lock 是具体类（java.util.concurrent.locks.lock）是api层面的锁。
 *
 * 2. 使用方法
 *   * synchronized 不需要用户手动去释放锁，当 synchronized 代码执行完后系统会自动让线程释放对锁的占用。
 *   * ReentrantLock 则需要用户手动的释放锁，若没有主动释放锁，可能导致出现死锁的现象，lock() 和 unlock() 方法需要配合 try/finally 语句来完成。
 *
 * 3.等待是否可以中断
 *   * synchronized 不可中断，除非抛出异常或者正常运行完成。
 *   * ReentrantLock 可中断，设置超时方法 tryLock(long timeout, TimeUnit unit)，lockInterruptibly() 放代码块中，调用 interrupt() 方法可中断。
 *
 * 4.加锁是否公平
 *   * synchronized 非公平锁
 *   * ReentrantLock 默认非公平锁，构造方法中可以传入 boolean 值，true 为公平锁，false 为非公平锁。
 *
 * 5.锁可以绑定多个 Condition
 *   * synchronized 没有 Condition。
 *   * ReentrantLock 用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像 synchronized 要么随机唤醒一个线程要么唤醒全部线程。
 *
 * */



/**
 * 题目：多线程之间按顺序调用，实现A->B->C三个线程的启动，要求如下
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15次
 * 。。。。
 * 进行10轮
 *
 * */

class ShareResource{
    private int number = 1;//A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    //1.判断
    public void print5(){
        lock.lock();
        try{
            //1.判断
            while(number != 1){
                condition1.await();
            }
            //2.干活
            for (int i = 1; i <= 5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.通知
            number = 2;
            condition2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            //1.判断
            while(number != 2){
                condition2.await();
            }
            //2.干活
            for (int i = 1; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.通知
            number = 3;
            condition3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            //1.判断
            while(number != 3){
                condition3.await();
            }
            //2.干活
            for (int i = 1; i <= 15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3.通知
            number = 1;
            condition1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResource.print5();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResource.print10();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResource.print15();
            }
        },"t3").start();
    }
}
