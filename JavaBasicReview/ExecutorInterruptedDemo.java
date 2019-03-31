
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  11:08
 * @description: Executor的中断操作
 */
public class ExecutorInterruptedDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(()->{
            try{
                Thread.sleep(2000);
                System.out.println("Thread run!");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        es.shutdownNow();
        //es.shutdown();
        System.out.println("Main run");

    }

}
