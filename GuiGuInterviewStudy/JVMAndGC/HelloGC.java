package JVMAndGC;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  10:57
 * @description: 打印GC收集细节
 *               打印-Xms -Xmx
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {

//        System.out.println("******hello GC******");
//        //byte[] bytes = new byte[50*1024*1024];
//        Thread.sleep(Integer.MAX_VALUE);

        long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机试图使用的最大内存量
        //默认的堆内存是本机内存的1/64
        System.out.println("TOTAL_MEMORY(-Xms) =" + totalMemory + "(字节)、" + (totalMemory / (double)1024) / 1024 + "MB");
        //最大内存量一般为本机内存的1/4
        System.out.println("MAX_MEMORY(-Xmx) =" + maxMemory + "(字节)、" + (maxMemory / (double)1024) / 1024 + "MB");

    }
}
