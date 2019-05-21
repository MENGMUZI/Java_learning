package JVMAndGC;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;


/**
 * @author : mengmuzi
 * create at:  2019-05-14  20:49
 * @description: 引用队列 ==> GC后的对象会被添加到引用队列中
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        System.out.println(o1);//java.lang.Object@61bbe9ba
        System.out.println(weakReference.get());//java.lang.Object@61bbe9ba
        System.out.println(referenceQueue.poll());//null

        System.out.println("=====================");
        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);//null
        System.out.println(weakReference.get());//null
        System.out.println(referenceQueue.poll());//java.lang.ref.WeakReference@610455d6
        

    }
}
