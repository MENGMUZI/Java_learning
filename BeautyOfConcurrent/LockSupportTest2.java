import java.util.concurrent.locks.LockSupport;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  10:45
 * @description: park和 unpark
 */
public class LockSupportTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");

                //调用park函数，挂起自己
                LockSupport.park();

                System.out.println("child thread unpark!");
            }
        });

        //启动子线程
        thread.start();
        //主线程休眠1S
        Thread.sleep(1000);
        System.out.println("main thread begin unpark!");

        //调用 unpark方法让 thread线程持有许可证，然后 park方法返回
        LockSupport.unpark(thread);

    }

}
