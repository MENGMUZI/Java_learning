import java.util.concurrent.CountDownLatch;

/**
 * @author : mengmuzi
 * create at:  2019-05-24  02:06
 * @description: 闭锁：在完成某些运算，只有其他所有线程运算完成，当前运算才能继续
 */
//想要获得10个线程执行的时间使用CountDownLatch
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(10);
        CDLThread cdlThread = new CDLThread(cdl);
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10 ; i++) {
            new Thread(cdlThread).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("10个线程花费的时间："+ (end - start) +"ms");

    }
}
class CDLThread implements Runnable{
    private CountDownLatch cdl;

    public CDLThread(CountDownLatch cdl){
        this.cdl = cdl;
    }
    @Override
    public void run() {
        synchronized (this){
            try{
                for (int i = 0; i <30000 ; i++) {
                    if(i%2 == 0){
                        System.out.println(i);
                    }
                }
            }finally {
                cdl.countDown();
            }

        }

    }
}