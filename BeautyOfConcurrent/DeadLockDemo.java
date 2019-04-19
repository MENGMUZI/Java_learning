/**
 * @author : mengmuzi
 * create at:  2019-04-19  20:36
 * @description: 线程死锁
 */
public class DeadLockDemo {

    //创建资源
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println(Thread.currentThread() + "get lockA");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get lockB");
                    synchronized (lockB){
                        System.out.println(Thread.currentThread() + "get lockB");
                    }
                }
            }
        });


        //创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println(Thread.currentThread() + "get lockB");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get lockA");
                    synchronized (lockA){
                        System.out.println(Thread.currentThread() + "get lockA");
                    }
                }
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
    }

}
