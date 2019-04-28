import java.util.concurrent.locks.StampedLock;

/**
 * @author : mengmuzi
 * create at:  2019-04-26  01:43
 * @description: StampedLock管理二维点
 */
public class Point {
    //成员变量
    private double x,y;
    //锁实例
    private final StampedLock s1 = new StampedLock();

    //排它锁（写锁  writeLock）
    void move(double deltaX ,double deltaY){
        long stamp = s1.writeLock();
        try{
            x += deltaX;
            y += deltaY;
        }finally{
            s1.unlockWrite(stamp);
        }
    }

    //乐观锁（tryOptimisticRead）
    double distanceFromOrigin(){
        //(1)尝试获取乐观读锁
        long stamp = s1.tryOptimisticRead();
        //将全部变量复制到方法体内
        double currentX = x, currentY = y;
        //)检查在( 1 )处获取 了读锁戳记后 ，锁有没被其他写线程排它性抢占
        if(!s1.validate(stamp)){
            //( 4 )如果被抢占则获取一个共享读锁(悲观获取)
            stamp = s1.readLock();
            try{
                //将全部变量复制到方法体内
                currentX = x;
                currentY = y;
            }finally {
                //释放共享读锁
                s1.unlockRead(stamp);
            }
        }
        //返回计算结果
        return Math.sqrt(currentX * currentX + currentY * currentY);

    }

    //使用悲观锁获取读锁，并尝试转化为写锁
    void moveIfAtOrigin(double newX , double newY){
        //( 1 )这里可以使用乐观读锁替换
        long stamp = s1.readLock();
        try{
            //( 2 )如采当前点在原点则移动
            while(x == 0.0 && y == 0.0) {
                //（3）尝试将获取的读锁升级为 写锁
                long ws = s1.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }else{
                    s1.unlockRead(stamp);
                    stamp = s1.writeLock();
                }
            }
        }finally {
            s1.unlock(stamp);
        }

    }
}
