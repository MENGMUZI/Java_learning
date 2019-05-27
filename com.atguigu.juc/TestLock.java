import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-05-24  14:55
 * @description: 解决多线程安全问题的方式：
 *              synchronized:隐式锁
 *              1.同步代码块
 *              2.同步方法
 *
 *              jdk1.5后
 *              3.同步锁 Lock
 *              手动上锁解锁
 *
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 1; i <= 3 ; i++) {
            new Thread(ticket,"窗口"+ String.valueOf(i)).start();
        }
    }

}
//不上锁引发线程安全问题，引入Lock
class Ticket implements Runnable{
    private Lock lock = new ReentrantLock();
    private int ticket =100;
    @Override
    public void run() {
        while(true){
            //上锁
            lock.lock();
            if(ticket > 0){
                try{
                    //暂停一会儿线程
                    try{ TimeUnit.MILLISECONDS.sleep(20);}catch(Exception e){e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + (--ticket));
                }finally {
                    lock.unlock();
                }
            }

        }
    }
}
