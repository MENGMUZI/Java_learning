package JVMAndGC;

/**
 * @author : mengmuzi
 * create at:  2019-06-10  21:09
 * @description: 堆内存的调优
 */
public class TestGCHeap {

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();//java虚拟机试图使用的最大内存量(1/4)

        long totalMemory = Runtime.getRuntime().totalMemory();//java虚拟机中的内存总量(1/64)

        System.out.println("MAX_MEMORY =" + maxMemory + "(字节)" + "、" + (maxMemory / (double) 1024 / 1024) + "MB");//MAX_MEMORY =1908932608(字节)、1820.5MB

        System.out.println("TOTAL_MEMORY =" + totalMemory + "(字节)" + "、" + (totalMemory / (double) 1024 / 1024) + "MB");//TOTAL_MEMORY =128974848(字节)、123.0MB

    }

}//-Xmx1024m -Xms1024m -XX:+PrintGCDetails
