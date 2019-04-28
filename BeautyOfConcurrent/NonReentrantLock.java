import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  20:43
 * @description: 基于 AQS 实现的不可重入的独 占锁。
 */
class NonReentrantLock implements Lock,java.io.Serializable {

    //内部帮助类
    private static class Sync extends AbstractQueuedSynchronizer{
        //是否锁被持有
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
        //如果state为 0 则尝试获取锁
        public boolean tryAcquire(int acquires){
            assert acquires == 1;
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放锁，设置state为0
        protected boolean tryRelease(int release){
            assert release == 1;
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        //提供条件变量的接口
        Condition newCondition(){
            return new ConditionObject();
        }


    }
    //创建一个Sync来做具体的工作
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);//state等于1表示锁被某个线程所持有
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
