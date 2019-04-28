import java.util.concurrent.locks.LockSupport;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  12:56
 * @description: 另外 park 方法还支持带有 blocker 参数 的方法
 * void park(Object blocker) 方法，当钱程 在没有持有许可证的情况下调用
 * park方法而被阻塞挂起时，这个 blocker对象会被记录到 该线程 内部 。
 */
public class TestPark {

    public void testPark(){
        LockSupport.park();
    }

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.testPark();
    }
}
