/**
 * @author : mengmuzi
 * create at:  2019-04-19  20:14
 * @description:
 */
public class InterruptDemo4 {
    public static void main(String[] args) throws InterruptedException {

        Thread threadone = new Thread(new Runnable() {
            @Override
            public void run() {
                //中断标志为 true时会退出循环，并且清除中断标志
                while(!Thread.currentThread().interrupted()){//中断标志为 true时会退出循环，并且清除中断标志

                }
                System.out.println("threadone interrupted:" + Thread.currentThread().isInterrupted());
            }
        });

        //启动线程
        threadone.start();
        //设置中断标志
        threadone.interrupt();

        threadone.join();
        System.out.println("main thread is over!");

    }

}
