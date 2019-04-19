/**
 * @author : mengmuzi
 * create at:  2019-04-19  20:48
 * @description: 守护线程
 *
 *守护线程和用户线程：最后一个非守护线程结束的时候，JVM会正常退出，不管当前是否有守护线程，守护线程是否结束不会影响JVM 的退出
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
        /*Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){

                }
            }
        });
        //设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("main thread is over");*/



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });
        //启动子线程
        thread.start();
        System.out.println("main thread is over");
    }

}
