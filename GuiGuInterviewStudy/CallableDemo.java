import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-13  10:31
 * @description: 多线程的Callable实现
 * Callable出现的作用：
 *
 */

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception{
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "=========come in Callable=========");
        return 1024;
    }
}
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * Thread的构造方法中没有传入callable的构造函数，只有Thread(Runnable target)Runnable接口的构造函数，
         * 需要找一个中间的代理，Runnable的子接口 ===> 有RunnableFuture接口 ===> 实现类FutureTask
         * 构造函数 FutureTask(Callable<V> callable)
         * */
        //FutureTask(Callable<V> callable)
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AAAAA").start();
        new Thread(futureTask,"BBBBB").start();//多线程抢futureTask，只会有一个线程进来
        //int result02 = futureTask.get();//若线程刚刚开启就去获得，势必会等待计算完成
        System.out.println(Thread.currentThread().getName() + "*************");
        int result01 = 100;
        while(!futureTask.isDone()){

        }
        int result02 = futureTask.get();//要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，直到计算完成
        System.out.println("***********result:" + (result01 + result02));

    }
}
