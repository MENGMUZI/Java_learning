import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-05-11  17:14
 * @description: 传统版的生产者消费者模式
 * 题目要求：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，一共进行5轮
 *
 *多线程并发的操作口诀：
 *          1. 线程   操作    资源类
 *          2. 判断   干活    通知
 *          3. 防止虚假唤醒机制  如果线程数变多了，如果采用if 出错了，API中说明了
 */
class ShareData{//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws Exception{
        lock.lock();
        try{
            //1.判断
            while(number != 0){
                //等待，不能生产
                condition.await();
            }
            //2.干活
            number ++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知唤醒
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        try{
            //1.判断
            while(number == 0){
                //等待，不能消费
                condition.await();
            }
            //2.干活
            number --;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知唤醒
            condition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


}
public class ProdCunsumer_TraditionalDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();


    }

}
