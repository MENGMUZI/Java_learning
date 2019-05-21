/**
 * @author : mengmuzi
 * create at:  2019-05-12  02:10
 * @description: 生产者消费者模式的阻塞队列版
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *   volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 *
 *
 * */
class MyResource{
    private volatile boolean FLAG = true;//默认开启，进行生产 + 消费 volatile可见性
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {//传入blockingQueue的接口，适用于各种blockingQueue;
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());//反射，具体是什么blockingQueue
    }
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while(FLAG){
            data = String.valueOf(atomicInteger.incrementAndGet());// ++i
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 老板叫停，表示FLAG=false,生产动作结束！");
    }

    public void myConsumer() throws Exception{
        String result = null;
        while(FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(result == null || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }

    public void stop () throws Exception{
        this.FLAG = false;
    }

}

public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try{
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            try{
                myResource.myConsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Consumer").start();


        //暂停5秒钟
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒钟时间到，大老板的main线程叫停，活动结束！！！！！！！");
        myResource.stop();

    }
}
