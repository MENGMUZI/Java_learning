/**
 * @author : mengmuzi
 * create at:  2019-04-19  15:23
 * @description: 子线程在睡眠期间，主线程中断了它，所以子线程在调用sleep方法处抛出了InterruptedException异常。
 */
public class SleepInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("child thread is in sleep!");
                    Thread.sleep(10000);
                    System.out.println("child thread is in awake!");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        thread.start();
        //主线程休眠2s
        Thread.sleep(2000);//java.lang.InterruptedException: sleep interrupted
        //主线程中断子线程
        thread.interrupt();
    }

}
