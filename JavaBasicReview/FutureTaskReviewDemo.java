import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  16:02
 * @description: FutureTask 可用于异步获取执行结果或取消执行任务的场景。
 */
public class FutureTaskReviewDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i <100 ; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });
        Thread computeThread = new Thread(futureTask);
        computeThread.start();
        Thread otherThread = new Thread(()->{
            System.out.println("Other thread is running!!");
            try{
               Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }

}
