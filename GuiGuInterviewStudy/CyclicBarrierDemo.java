import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * @author : mengmuzi
 * create at:  2019-05-09  20:41
 * @description: 召唤7龙珠
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{System.out.println("********召唤神龙");});
        for (int i = 1; i <= 7 ; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t收集到第"+ finalI +"颗龙珠");
                try{
                    cyclicBarrier.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


    }

}
