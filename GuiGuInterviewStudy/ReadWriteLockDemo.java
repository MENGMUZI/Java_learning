import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : mengmuzi
 * create at:  2019-05-09  00:57
 * @description:ReentrantReadWriteLock
 *
 * 多个线程同时读一个资源类没有任何问题，所以满足并发量，读取共享资源应该可以同时进行
 * 但是如果一个资源想去写共享资源来，就不应该再有其他线程对该资源进行读或者写
 *  小总结： 读-读可以共存
 *          读-写不可以共存
 *          写-写不可以共存
 *
 *          写操作：原子+独占 ,整个过程必须是一个完整的统一体，中间不能被打断。
 *          * 若采用ReentrantLock，不能满足同读同写要求
 *
 *
 */
class MyCache{//资源类
    private volatile Map<String,Object> map = new HashMap();//要保证可见性和及时性

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();//读写锁

    public void put(String key, Object value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            //模拟网络拥堵
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：" );
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：" );
            //模拟网络拥堵
            try{
                TimeUnit.MILLISECONDS.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }
    }
    //清理缓存
    public void clearMap(){
        map.clear();
    }

}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5 ; i++) {
            int finalI = i;
            //5个写入线程
            new Thread(()->{
                myCache.put(String.valueOf(finalI),String.valueOf(finalI));
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5 ; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
    }
}
