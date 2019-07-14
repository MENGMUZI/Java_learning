import java.util.concurrent.*;

/**
 * @author : mengmuzi
 * create at:  2019-05-13  13:38
 * @description:第四种使用Java多线程的方式，线程池，
 *              手写一个线程池
 */
public class MyThreadPoolDemo {
    /**
     * 1.调用JDK自带的线程池
     * */
    public static void threadPoolInit(){
        //底层CPU的线程数
        //System.out.println(Runtime.getRuntime().availableProcessors());//8

        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor(); //一池1一个处理线程
        ExecutorService threadPool2 = Executors.newCachedThreadPool();//一池N个处理线程

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try{
            for (int i = 1; i <=20 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                //暂停一会儿线程
                //try{ TimeUnit.SECONDS.sleep(1);}catch(Exception e){e.printStackTrace();}
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }

    /**
     * 手写线程池
     * */

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        /**
         * 测试不同的拒绝策略：
         *  1. AbortPolicy()用户数为9时，出现java.util.concurrent.RejectedExecutionException
         *  2. CallerRunsPolicy()用户数为10时，出现 main办理业务，回退给main线程（打哪来回哪去）
         *  3. DiscardOldestPolicy()用户数大于8的时候，最多8个线程
         *  4. DiscardPolicy()用户数大于8的时候，最多8个线程
         * */
        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try{
            for (int i = 1; i <=10 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    //暂停一会儿线程
                    try{ TimeUnit.SECONDS.sleep(1);}catch(Exception e){e.printStackTrace();}
                });
                //暂停一会儿线程
                //try{ TimeUnit.SECONDS.sleep(1);}catch(Exception e){e.printStackTrace();}
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }

    }

}
