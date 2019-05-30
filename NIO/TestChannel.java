/**
 * @author : mengmuzi
 * create at:  2019-05-30  01:35
 * @description: Channel
 */

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、通道(Channel):用于源节点与目标节点的连接。在java NIO中负责缓冲区中数据的传输。
 *    Channel本身不存储数据，需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 * java.nio.channels.Channel 接口
 *  |-- FileChannel  用于读取、写入、映射和操作文件的通道。
 *  |-- SocketChannel  通过 TCP 读写网络中的数据。
 *  |-- ServerSocketChannel  可以监听新进来的 TCP 连接，对每一个新进来的连接都会创建一个 SocketChannel。
 *  |-- DatagramChannel  通过 UDP 读写网络中的数据通道。
 *
 * 三、获取通道
 * 1.java针对支持通道的类提供getChannel()方法
 *   本地IO
 *   FileInputStream/FileOutputStream
 *   RandomAccessFile
 *
 *   网络IO
 *   Socket
 *   ServerSocket
 *   DatagramSocket
 *
 * 2.在JDK 1.7 中的NIO.2 针对各个通道提供了静态方法 open()
 *
 * 3.在JDK 1.7 中的NIO.2 的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散（Scatter）与聚集（Gatter）
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中.
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中.
 *
 *
 * */
public class TestChannel {

    //1.利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test1(){
        long start = System.currentTimeMillis();
        FileInputStream fis=null;
        FileOutputStream fos=null;

        FileChannel inChannel=null;
        FileChannel outChannel=null;
        try {
            fis = new FileInputStream("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test1.jpg");
            fos = new FileOutputStream("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test2.jpg");

            //1.获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //2.分配一个指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3.将通道中的数据存入缓冲区
            while (inChannel.read(buf) != -1){
                buf.flip();//将buffer切换到读取数据的模式
                //4.将缓冲区的数据写入通道中
                outChannel.write(buf);
                buf.clear(); //清空缓冲区
            }

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start) + "ms");//39ms

    }

    //2.使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2(){
        long start = System.currentTimeMillis();
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test1.jpg"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

            //内存映射文件(物理内存)
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-start) + "ms");// 25ms
    }

    //3.通道之间的数据传输（直接缓冲区）
    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test1.jpg"),StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

            inChannel.transferTo(0,inChannel.size(),outChannel);
            outChannel.transferFrom(inChannel,0,inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();

        }finally{
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("耗费的时间为："+ (end-start) +"ms");//36ms

    }

    //4.分散和聚集
    @Test
    public void test4(){
        RandomAccessFile raf1 = null ;
        

    }





}
