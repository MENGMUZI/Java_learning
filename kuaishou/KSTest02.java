import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-08-26  21:08
 * @description:
 */
public class KSTest02 {

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(".....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        System.out.println(Thread.currentThread().getName());

    }

}
