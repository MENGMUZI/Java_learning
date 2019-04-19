/**
 * @author : mengmuzi
 * create at:  2019-04-19  16:15
 * @description: 线程中断
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出线程
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() + "hello");
                }
            }
        });
        //启动子线程
        thread.start();

        //主线程休眠1s，以使中断前让子线程输出
        Thread.sleep(1000);

        //中断子线程
        System.out.println("main thread interrupt thread!");
        thread.interrupt();

        //等待子线程执行完毕
        thread.join();
        System.out.println("main is over!");
    }

}
