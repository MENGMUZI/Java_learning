/**
 * @author : mengmuzi
 * create at:  2019-04-19  16:49
 * @description: 了解 interrupted()与 islntem1pted()方法的不同之处
 *
 * interrupted()方法内部是获取当前线程的中断状态，这里虽然调用了thread的interrupted()方法，
 * 但是获取的是主线程的中断标志，因为主线程是当前线程。
 * thread.interrupted()和 Thread.interrupted()方法的作用是一样的，目的都是获取当前线程的中断标志 。
 */
public class InterruptDemo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread is running!!");
            }
        });

        //启动线程
        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());//true
        //获取中断标志位并重置
        System.out.println("Interrupted:" + thread.interrupted());//false
        //获取中断标志位并重置
        System.out.println("Interrupted:" + Thread.interrupted());//false
        //获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());//true

        thread.join();
        System.out.println("main thread is over!!!");
    }

}
