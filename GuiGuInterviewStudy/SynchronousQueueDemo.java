import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-09  22:56
 * @description:
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName() + "\t put a");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + "\t put b");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "\t put c");
                blockingQueue.put("c");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"AAAA").start();

        new Thread(()->{
            try{
                //暂停5秒钟
               try{ TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){ e.printStackTrace(); }
               System.out.println(Thread.currentThread().getName()+ "\t take " + blockingQueue.take());

               try{ TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){ e.printStackTrace(); }
               System.out.println(Thread.currentThread().getName()+ "\t take " + blockingQueue.take());

               try{ TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){ e.printStackTrace(); }
               System.out.println(Thread.currentThread().getName()+ "\t take " + blockingQueue.take());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },"BBBB").start();

    }

}
