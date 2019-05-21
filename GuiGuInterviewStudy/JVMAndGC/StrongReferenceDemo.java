package JVMAndGC;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  16:38
 * @description: 强引用
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1 = new Object();//默认定义为强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1 = null;
        System.gc();
        System.out.println(obj2);//java.lang.Object@61bbe9ba
        System.out.println(obj1);//null

    }
}
