import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  16:17
 * @description: 多个线程访问同一个方法的局部变量时，不会出现线程安全问题，因为局部变量存储在虚拟机栈中，属于线程私有的。
 */
public class StackClosedReviewDemo {
    public static class StackClosedExample{
        public void add100() {
            int cnt = 0;
            for (int i = 0; i < 100; i++) {
                cnt++;
            }
            System.out.println(cnt);
        }
    }
    public static void main(String[] args) {
        StackClosedExample stackClosedExample = new StackClosedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->stackClosedExample.add100());
        executorService.execute(()->stackClosedExample.add100());
        executorService.shutdown();
    }
}
