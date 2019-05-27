import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  03:12
 * @description: 编写一个程序，开启三个线程，分别是ABC，每个线程将自己ID在屏幕上打印10遍，如：ABCABCABC。。。依次进行
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlternateDemo alternateDemo = new AlternateDemo();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                alternateDemo.loopA(i);
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                alternateDemo.loopB(i);
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                alternateDemo.loopC(i);
            }
        },"C").start();

    }

}
class AlternateDemo{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int totalLoop){//totalLoop循环的轮数
        lock.lock();
        try{
            //判断
            if(number != 1){
                condition1.await();
            }
            //打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t"+ totalLoop);
            }
            //唤醒2
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop){//totalLoop循环的轮数
        lock.lock();
        try{
            //判断
            if(number != 2){
                condition2.await();
            }
            //打印
            for (int i = 1; i <= 1 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t"+ totalLoop);
            }
            //唤醒2
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop){//totalLoop循环的轮数
        lock.lock();
        try{
            //判断
            if(number != 3){
                condition3.await();
            }
            //打印
            for (int i = 1; i <= 1 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t"+ totalLoop);
            }
            //唤醒2
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
