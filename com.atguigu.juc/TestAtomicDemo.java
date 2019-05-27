import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : mengmuzi
 * create at:  2019-05-24  01:25
 * @description: 原子性问题：i++实际上分成3步"读改写"
 *               采用原子变量： 1. volatile 保证内存可见性
 *                            2. CAS算法保证数据的原子性
 *                              CAS算法是硬件对于并发操作共享数据的支持
 *                              CAS包括三个操作数：
 *                              内存值 V
 *                              预估值 A
 *                              更新值 B
 *                              当且仅当 V==A 时，V = B 否则，不做任何操作
 *
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 1; i <= 10 ; i++) {
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable{
    //private int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();
    @Override
    public void run() {
        //暂停一会儿线程
        try{ TimeUnit.MILLISECONDS.sleep(200);}catch(Exception e){e.printStackTrace();}
        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }

    public int getSerialNumber() {
        //return serialNumber++;
        return serialNumber.getAndIncrement();
    }

}