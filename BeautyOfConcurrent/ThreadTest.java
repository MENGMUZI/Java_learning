import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author : mengmuzi
 * create at:  2019-04-19  01:28
 * @description: Java 中有三种线程创建方式，分别为实现 Runnable接口的 run方法，继承 Thread类 并重写 run 的方法，使用 Fu阳reTask方式。
 */
public class ThreadTest {
    //继承Thread类方式实现
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a child Thread created by Thread!");
        }
    }

    //实现Runnable接口
    public static class RunableTask implements Runnable{
        @Override
        public void run(){
            System.out.println("I am a child Thread created by Runnable!");
        }
    }

    //实现callable接口，利用FutureTask
    public static class CallableTask implements Callable<String> {
        @Override
        public String call(){
            return "hello world!";
        }
    }


    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.run();


        Runnable runnabletask = new RunableTask();
        new Thread(runnabletask).start();
        new Thread(runnabletask).start();

        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallableTask());
        //启动线程
        new Thread(futureTask).start();
        try{
          //等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
