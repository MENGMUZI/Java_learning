/**
 * @author : mengmuzi
 * create at:  2019-04-19  11:45
 * @description:当一 个线程调用 共享对象 的 wait()方法被阻塞挂起后，
 * 如果其他线程中断了该线程， 则该线程会抛出 InterruptedException异常并返回
 */
public class WaitNotifyInterupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("-------------begin----------------");
                    //阻塞当前线程
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("-------------end-----------------");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("--------begin interrupt thread----------");
        //Thread.sleep(1000);
        thread.interrupt();
        System.out.println("--------end interrupt thread----------");
    }

}
