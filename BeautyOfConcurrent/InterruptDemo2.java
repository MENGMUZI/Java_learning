/**
 * @author : mengmuzi
 * create at:  2019-04-19  16:29
 * @description: 通过调用 threadOne.interrupt()方法打断了该线程的休眠，
 * 该线程会 在调用 sleep方法处抛出 InterruptedException异常后返回。
 */
public class InterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadone = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("threadone begin sleep for 2000 seconds!");
                    Thread.sleep(2000);
                    System.out.println("threadone is in awake!");

                }catch(Exception e){
                    //System.out.println("threadone is interrupted while sleeping");
                    //return;
                    e.printStackTrace();
                    return;
                }
                System.out.println("threadone-leaving normally!!");
            }
        });
        //启动线程
        threadone.start();
        Thread.sleep(1000);

        //打断子线程的休眠，让子线程从sleep函数返回
        threadone.interrupt();

        //等待子线程执行完毕
        threadone.join();

        System.out.println("main thread is over!");
    }
}
