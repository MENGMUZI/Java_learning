import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-13  17:04
 * @description: 死锁
 */
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run(){
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t尝试获得：" + lockB);
            //暂停一会儿线程
            try{ TimeUnit.SECONDS.sleep(2);}catch(Exception e){e.printStackTrace();}
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t尝试获得：" + lockA);
            }
        }
    }
}
public class DeadLockDemoOne {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"t1").start();
        new Thread(new HoldLockThread(lockB,lockA),"t2").start();

        /**
         * linux ps -ef|grep xxxxx  ls -l
         * window下的Java运行程序，也有类似ps 的查看命令，但是目前我们需要查看只是Java
         *  jps = java ps    jps -l
         *  下一步 jstack 【进程号】
         *
         * */
    }

}
