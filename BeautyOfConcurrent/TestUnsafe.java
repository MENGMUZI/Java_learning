import sun.misc.Unsafe;

/**
 * @author : mengmuzi
 * create at:  2019-04-24  01:29
 * @description: 使用unsafe
 */
public class TestUnsafe {
    //获取Unsafe的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();
    //记录变量state在类TestUnSafe中的偏移位
    static long stateOffset;
    //变量
    private volatile long state = 0;

    static{
        try{
            //获取state变量在类TestUnSafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建实例 ，并且设置 state值为 1
        TestUnsafe test = new TestUnsafe();
        //
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }
}
