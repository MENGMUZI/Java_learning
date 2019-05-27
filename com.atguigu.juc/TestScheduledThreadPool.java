import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  16:37
 * @description:
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i <10 ; i++) {
            Future future = scheduledExecutorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ":" +num);
                    return num;
                }
            },1, TimeUnit.SECONDS);

            System.out.println(future.get());
        }
        scheduledExecutorService.shutdown();
    }

}
