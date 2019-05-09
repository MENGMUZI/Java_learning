import java.util.concurrent.CountDownLatch;

/**
 * @author : mengmuzi
 * create at:  2019-05-09  02:17
 * @description: * CountDownLatch演示班长锁门
 *               * CountDownLatch演示秦灭六国的案例，引入枚举类
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "国被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t六国被灭，大秦一统天下！！！！！");

    }

    public static void closeDoor() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t上晚自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t***********班长关门走人！！！！！");
    }
}
