/**
 * @author : mengmuzi
 * create at:  2019-05-09  21:23
 * @description: 阻塞队列
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 1.队列
 *
 * 2.阻塞队列
 *   2.1 阻塞队列有没有好的一面
 *
 *   2.2 不得不阻塞，你如何管理
 *
 *
 *
 *
 * */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        /**
         * 第一组抛出异常
         * */
        System.out.println("========第一组抛出异常=========");
        //插入 add()方法
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);//有界队列
        System.out.println(blockingQueue.add("A"));
        System.out.println(blockingQueue.add("B"));
        System.out.println(blockingQueue.add("C"));
        //System.out.println(blockingQueue.add("A"));//Exception in thread "main" java.lang.IllegalStateException: Queue full

        //检查 element()方法
        System.out.println(blockingQueue.element());//A

        //移除 remove()方法
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());//Exception in thread "main" java.util.NoSuchElementException

        System.out.println("========第二组特殊值===========");

        /**
         * 第二组特殊值
         * */
        //添加 offer()方法
        BlockingQueue<String> blockingQueue1 = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue1.offer("A"));
        System.out.println(blockingQueue1.offer("B"));
        System.out.println(blockingQueue1.offer("C"));
        System.out.println(blockingQueue1.offer("D"));//false

        //检查 peak() 方法
        System.out.println(blockingQueue1.element());

        //移除 poll() 方法
        System.out.println(blockingQueue1.poll());
        System.out.println(blockingQueue1.poll());
        System.out.println(blockingQueue1.poll());
        System.out.println(blockingQueue1.poll());//null

        /**
         * 第三组一直阻塞
         * */
        System.out.println("========第三组一直阻塞，不见不散===========");

        //添加 put()方法
        BlockingQueue<String> blockingQueue2 = new ArrayBlockingQueue<>(3);
        blockingQueue2.put("a");
        blockingQueue2.put("b");
        blockingQueue2.put("c");
        //blockingQueue2.put("x");//线程阻塞

        //移除 take()方法
        blockingQueue2.take();
        blockingQueue2.take();
        blockingQueue2.take();
        //blockingQueue2.take();//线程阻塞

        /**
         * 第四组阻塞超时退出
         * */
        System.out.println("========第四组阻塞超时退出，过时不候===========");

        BlockingQueue<String> blockingQueue3 = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue3.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue3.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue3.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue3.offer("a",2L, TimeUnit.SECONDS));//阻塞2S后，false

        System.out.println(blockingQueue3.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue3.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue3.poll(2L,TimeUnit.SECONDS));
        System.out.println(blockingQueue3.poll(2L,TimeUnit.SECONDS));//阻塞2S后，null




    }


}
