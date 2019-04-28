import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  21:11
 * @description: 使用自定义锁实现生产一消费模型
 */
public class NonReentrantLockDemo {

    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();
    final static Queue<String> queue = new LinkedBlockingDeque<>();
    final static int queueSize = 10;

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取独占锁
                lock.lock();
                try{
                    //1.如果队列满了，则等待
                    while(queue.size() == queueSize){
                        notEmpty.await();
                    }
                    //2.添加元素到队列
                    queue.add("ele");
                    //3.唤醒消费线程
                    notFull.signalAll();

                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    //释放锁
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while(queue.size() == 0){
                        notFull.await();
                    }
                    String ele = queue.poll();
                    System.out.println(ele);
                    notEmpty.await();
                }catch(Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();

    }

}
