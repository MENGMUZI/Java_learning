import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  03:00
 * @description:  采用Condition和Lock的消费者和生产者模型
 */
public class TestProducerAndConsumerForLock {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        MyProductor mp = new MyProductor(clerk);
        MyConsumer mc = new MyConsumer(clerk);

        new Thread(mp,"生产者A").start();
        //new Thread(mp,"生产者B").start();
        new Thread(mc,"消费者A").start();
        //new Thread(mc,"消费者B").start();

    }
}
//店员
class LClerk{
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //进货
    public void get(){
        lock.lock();
        try{
            while(product >= 1){//防止虚假唤醒
                System.out.println("产品已经满了！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + (++product));
            condition.signalAll();
        }finally {
            lock.unlock();
        }


    }
    //卖货
    public void sale(){
        lock.lock();
        try{
            while(product <= 0){
                System.out.println("缺货！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + (--product));
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

}
//生产者
class LMyProductor implements Runnable{
    private Clerk clerk ;
    public LMyProductor(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            clerk.get();
        }
    }
}
//消费者
class LMyConsumer implements Runnable{
    private Clerk clerk;

    public LMyConsumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            //暂停一会儿线程
            try{ TimeUnit.MILLISECONDS.sleep(200);}catch(Exception e){e.printStackTrace();}
            clerk.sale();
        }
    }
}

