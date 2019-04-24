import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : mengmuzi
 * create at:  2019-04-24  01:52
 * @description:使用万能的反射来获取
 * Unsafe 实 例 方法
 */
public class TestUnsafe2 {

    static Unsafe unsafe;
    static long stateOffset;
    private volatile long state = 0;

    static{
        try{
            //使用反射获取Unsafe的成员变量 theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //java的反射中,通过字段获取对象,null表示静态的
            unsafe = (Unsafe) field.get(null);
            //获取state在TestUnSafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnsafe2.class.getDeclaredField("state"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //创建实例 ，并且设置 state1直为 1
        TestUnsafe2 test = new TestUnsafe2();
        //
        Boolean success = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(success);
    }


}
