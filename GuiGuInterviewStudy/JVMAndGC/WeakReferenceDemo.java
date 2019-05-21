package JVMAndGC;

import java.lang.ref.WeakReference;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  17:21
 * @description: 弱引用  只要发生GC就回收
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);//java.lang.Object@61bbe9ba
        System.out.println(weakReference.get());//java.lang.Object@61bbe9ba
        o1 = null;
        System.gc();
        System.out.println(o1);//null
        System.out.println(weakReference.get());//null
    }
}
