
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  16:53
 * @description: Fork-Join并行运算框架
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinSumCalculate(0L,1000000000L);
        Long sum = forkJoinPool.invoke(forkJoinTask);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费的时间：" + Duration.between(start,end).toMillis() + "ms");
    }
    @Test
    public void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i <= 1000000000L ; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费的时间：" + Duration.between(start,end).toMillis() + "ms");

    }
    //Java8新特性
    @Test
    public void test2(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L,1000000000L)
                             .parallel()
                             .reduce(0L,Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费的时间：" + Duration.between(start,end).toMillis() + "ms");
    }

}
class ForkJoinSumCalculate extends RecursiveTask<Long>{
    private static final long serialVersionUID = -259195479995561737L;
    private long start;
    private long end;
    private static final long THRESHOLD = 10000L;//临界值
    public ForkJoinSumCalculate(long start,long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD){
            long sum = 0L;
            for (long i = start; i <= end ; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle +1 ,end);//注意是middle+1
            right.fork();
            return left.join() + right.join();
        }
    }
}
