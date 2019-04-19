/**
 * @author : mengmuzi
 * create at:  2019-04-19  15:48
 * @description: 当一个线程调用yield方法时，
 * 当前线程会让出CPU使用权，然后处于就绪状态，
 * 线程调度器会从线程就绪队列里面获取一个线程优先级最高的线程，
 * 当然也有可能会调度到 刚刚让出CPU的那个线程来获取CPU执行权。
 */
public class YieldThreadDemo implements Runnable{

    YieldThreadDemo(){
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            if ((i % 5 )== 0) {
                System.out.println(Thread.currentThread() + "yield cpu....");
                //当前线程让 出CPU执行权，放弃时间片，进行下一轮调度
                Thread.yield();
            }
            System.out.println(Thread.currentThread() + "cpu get back....");
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldThreadDemo();
        new YieldThreadDemo();
        new YieldThreadDemo();
    }
}
