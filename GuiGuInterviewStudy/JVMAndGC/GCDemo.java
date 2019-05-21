package JVMAndGC;

/**
 * @author : mengmuzi
 * create at:  2019-05-20  01:52
 * @description: 7大垃圾收集器
 */

import java.util.Random;

/**
 * 1.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC    (DefNew + Tenured)
 *
 * 2.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC    (ParNew + Tenured)
 *     Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector
 *     is deprecated and will likely be removed in a future release
 *
 * 3.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC  (PSYoungGen + ParOldGen)
 *
 * 4.
 *  4.1-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC (PSYoungGen + ParOldGen)
 *  4.2-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags(Java8下的默认配置)
 *
 * 5.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC (par new generation + concurrent mark-sweep generation)
 *
 * 6.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC      后面单独讲解G1
 *
 * 7.-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC (JAVA8后没有了)
 * */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("****************GCDemo**************8");
        try{
            String str = "mengmuzi";
            while(true){
                str += str + new Random().nextInt(77777777) + new Random().nextInt(888888888);
                str.intern();

            }
        }catch (Exception e){
            e.printStackTrace();

        }
    }

}
