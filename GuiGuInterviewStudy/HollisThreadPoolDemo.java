import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author : mengmuzi
 * create at:  2019-07-14  13:56
 * @description: Hollis大佬文章中写的，使用guava提供的ThreadFactoryBuilder创建线程池，
 *               这样的方式创建线程时，可以避免oom的问题，还可以自定义线程的名字。
 */
public class HollisThreadPoolDemo {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("hollisDemo-pool-%d")
            .build();

    private static ExecutorService threadPool = new ThreadPoolExecutor(
            5,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(1024),
            //Executors.defaultThreadFactory(),
            threadFactory,
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() +"\t"+ "正在执行任务。。。");
            });
        }
    }

}
