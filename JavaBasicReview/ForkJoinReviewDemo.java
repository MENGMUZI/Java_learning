import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author : mengmuzi
 * create at:  2019-03-31  17:18
 * @description: ForkJoin  主要用于并行计算中，和 MapReduce 原理类似，都是把大的计算任务拆分成多个小任务并行计算
 */
public class ForkJoinReviewDemo extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first;
    private int last;
    public ForkJoinReviewDemo(int first, int last){
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if(last - first <= threshold){
            //任务足够小的时候可以计算
            for (int i = first; i <=last ; i++) {
                result += i;
            }
        }else{
            //任务要拆解成小任务
            int middle = first + (last-first)>>1;
            ForkJoinReviewDemo leftTask = new ForkJoinReviewDemo(first,middle);
            ForkJoinReviewDemo rightTask = new ForkJoinReviewDemo(middle+1,last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinReviewDemo forkJoinReviewDemo = new ForkJoinReviewDemo(1,10);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(forkJoinReviewDemo);
        System.out.println(result.get());
    }
}
