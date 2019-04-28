import java.util.concurrent.locks.LockSupport;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  11:02
 * @description:
 */
public class LockSupportTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                //调用park方法，挂起自己，只有被中断才会退出循环
                while(!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("child thread unpark!");
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");
        thread.interrupt();
        //LockSupport.unpark(thread);
    }

}
