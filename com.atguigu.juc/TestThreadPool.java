import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  15:26
 * @description: 线程池
 * 一、线程池：提供一个线程队列，队列中保存着所有等待状态的线程，避免了创建和销毁的额外开销，提高了响应的速度
 *
 * 二、线程池的体系结构：
 *      java.util.concurrent.Executor :负责线程的使用与调度的根接口
 *         |-- ExecutorService 子接口：线程池的接口
 *            |-- ThreadPoolExecutor 线程池的实现类
 *            |-- ScheduledExecutorService 子接口：负责线程的调度
 *               |--ScheduledThreadPoolExecutor : 继承了ThreadPoolExecutor,实现了ScheduledExecutorService
 *
 * 三、线程池工具类Executors
 * ExecutorService newFixedThreadPool()
 * ExecutorService newCachedThreadPool()
 * ExecutorService newSingleThreadPoolExecutor()
 * ScheduledExecutorService newScheduledThreadPool() 创建固定大小的线程，可以延迟或定时的执行任务
 */
public class TestThreadPool {
    public static void main(String[] args) {
        /*
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

        //为线程池分配任务
        for(int i = 0; i <10 ; i++) {
            threadPool.submit(threadPoolDemo);
        }
        //关闭线程池
        threadPool.shutdown();
        */

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i <=10 ; i++) {
            Future<Integer> future = threadPool.submit(new Callable<Integer>() {
                private int number = 0;
                @Override
                public Integer call() throws Exception {
                    for (int i = 0; i <=100 ; i++) {
                        number += i;
                    }
                    return number;
                }
            });
            futures.add(future);
        }
        for (Future<Integer> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }

}
class ThreadPoolDemo implements Runnable{
    private int number = 0;
    @Override
    public void run() {
        while(number <= 100){
            System.out.println(Thread.currentThread().getName() + ":" + number++);
        }
    }
}
