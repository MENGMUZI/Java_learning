import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-03-29  20:58
 * @description: Lock中的condition
 */
/*
* 我们要打印1到9这9个数字，由A线程先打印1，2，3，然后由B线程打印4,5,6，然后再由A线程打印7，8，9.
 * */
public class ConditionReviewDemo {
    static int value = 1;
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Condition condtion1 = lock.newCondition();
        final Condition condtion2 = lock.newCondition();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    System.out.println("线程A开始打印");
                    while(value <= 3){
                        System.out.println(value);
                        value++;
                    }
                    condtion1.signal();
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                lock.lock();
                try{
                    condtion2.await();
                    System.out.println("线程A开始打印");
                    while(value <= 9){
                        System.out.println(value);
                        value++;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }

        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    while(value <= 3){
                        condtion1.await();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                lock.lock();
                try{
                    System.out.println("线程B开始打印");
                    while(value <= 6){
                        System.out.println(value);
                        value++;
                    }
                    condtion2.signal();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            }
        });
        A.start();
        B.start();

    }

}
