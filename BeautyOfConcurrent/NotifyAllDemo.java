/**
 * @author : mengmuzi
 * create at:  2019-04-19  14:00
 * @description: 不同于在共享变量上调用 notify()函数会唤醒被阻塞到该共享变量上的一个线程， notifyAll() 方法则会唤醒所有在该共享变量上由于调用 wait 系列方法而被挂起的线程。
 */
public class NotifyAllDemo {

    //创建锁资源
    private static volatile Object lockA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取监视器锁
                synchronized (lockA){
                    System.out.println("threadA get lockA");
                    try{
                        System.out.println("threadA begin wait");
                        lockA.wait();
                        System.out.println("threadA end wait");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取监视器锁
                synchronized (lockA){
                    System.out.println("threadB get lockA");
                    try{
                        System.out.println("threadB begin wait");
                        lockA.wait();
                        System.out.println("threadB end wait");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取监视器锁
                synchronized (lockA){
                    System.out.println("threadC start notify");
                    //lockA.notify();
                    lockA.notifyAll();

                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
        threadC.sleep(2000);
        threadC.start();
        //等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("Main Thread is over!!!");
    }

}
