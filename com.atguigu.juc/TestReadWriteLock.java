import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  14:24
 * @description: 读写锁：
 *                 写写、读写互斥
 *                 读读不用互斥
 *
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        MyReadWriteLockDemo mewl = new MyReadWriteLockDemo();
        new Thread(()->{
            mewl.set((int)(Math.random()*2019));//注意Math这边要加括号！！！！！！！！
        },"write").start();

        for (int i = 1; i <= 10 ; i++) {
            new Thread(()->{
                mewl.get();
            },String.valueOf("read" + i)).start();
        }
    }

}
class MyReadWriteLockDemo{
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void get(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + ":" + number);
        }finally {
            lock.readLock().unlock();
        }
    }

    //写
    public void set(int number){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
