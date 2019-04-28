import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : mengmuzi
 * create at:  2019-04-26  00:32
 * @description: 使用 ReentrantLock 实现线程安全的 list，但是由于 ReentrantLock 是 独占锁，所以在读多写少的情况下性能很差。
 */
public class ReentrantReadWriteLockDemo {
    private ArrayList<String> array = new ArrayList<>();
    //独占锁
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();

    //添加元素
    public void add(String e){
        writeLock.lock();
        try{
            array.add(e);
        }finally {
            writeLock.unlock();
        }
    }

    //删除元素
    public void remove(String e){
        writeLock.lock();
        try{
            array.remove(e);
        }finally {
            writeLock.unlock();
        }
    }

    //获取数据
    public String get(int index){
        readLock.lock();
        try{
            return array.get(index);
        }finally{
            readLock.unlock();
        }
    }

}
