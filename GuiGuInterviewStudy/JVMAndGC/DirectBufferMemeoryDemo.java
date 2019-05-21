package JVMAndGC;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  21:59
 * @description:  Direct buffer memory
 *                -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemeoryDemo {

    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:" + (sun.misc.VM.maxDirectMemory() / (double)1024 /1024) + "MB");
        //暂停一会儿线程
        try{ TimeUnit.SECONDS.sleep(2);}catch(Exception e){e.printStackTrace();}
        //-XX:maxDirectMemorySize = 5m 实际创建6m的对象
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
        //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
        //NIO中经常出现这样的异常
    }

}
