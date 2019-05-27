import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : mengmuzi
 * create at:  2019-05-24  14:43
 * @description: 创建执行线程三：实现callable接口
 *               相比较实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
 *               执行Callable的方式：需要FutureTask实现类的支持，用于接受运算结果。FutureTask是Future接口的实现类
 */
public class TestCallable {
    public static void main(String[] args) {
        CallDemo cd = new CallDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(cd);
        new Thread(futureTask).start();
        try {
            Integer sum = futureTask.get(); //可用于闭锁
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class CallDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <100 ; i++) {
            sum +=i;
        }
        return sum;
    }
}