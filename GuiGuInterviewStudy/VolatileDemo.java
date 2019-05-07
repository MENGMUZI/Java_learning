import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : mengmuzi
 * create at:  2019-05-07  02:14
 * @description: volatile可见性的证明
 */
class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    public void addPlusPlus(){
        number ++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }


}
/**
 * 1.验证volatile的可见性
 *   1.1 假如int number = 0； number变量之前根本没有添加volatile关键字,没有可见性
 *   1.2 添加了volatile，可以解决可见性问题
 *
 * 2.验证volatile不保证原子性
 *  2.1 原子性指什么？
 *  不可分割，完整性。
 *  2.2 volatile 不能保证原子性
 *  2.3 why 不能保证原子性？ 反编译发现是3步
 *  2.4 如何解决
 *    * 加sync
 *    * 使用juc下的AtomicInteger
 *
* */
public class VolatileDemo {

    public static void main(String[] args) {
        /*
        验证可见性
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);
        },"AAA").start();

        //第二个线程就是主线程
        while(myData.number == 0){
            //main线程一直在这里等待，直到number不再等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over ，main get the number value :"  + myData.number);
        */

        MyData myData = new MyData();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        //需要等待20个线程计算完成，再使用main线程取得最终的结果
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value :" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally number value :" + myData.atomicInteger);

    }
}

