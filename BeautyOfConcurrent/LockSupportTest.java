import java.util.concurrent.locks.LockSupport;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  10:29
 * @description: void park()方法
 */
public class LockSupportTest {

    public static void main(String[] args) {
        /**
         * 直接在 main 函数里面调用 park方法，
         * 最终只会输出 begin park!，然后当前线程被挂起，
         * 这是因为在默认情况下调用线程是不持有许可证的。
         * */
        /*
        System.out.println("begin park!");
        LockSupport.park();
        System.out.println("eng park!");
        */

        /**
         * 当一个线程调用 unpark 时，如果参数 thread 线程没有持有 thread 与 LockSupport 类 关联的许可证，
         * 则让 thread 线程持有。 如果 thread 之前因调用 park()而被挂起，则调用 unpark 后，该线程会被唤醒。
         * 如果 thread 之前没有调用 park，则 调用 unpark 方法后，再调用 park 方法，其会立刻返回.
         */
        System.out.println("Begin park!");
        //使当前线程获得许可证
        LockSupport.unpark(Thread.currentThread());
        //再次调用park方法
        LockSupport.park();
        System.out.println("end park!");

    }

}
