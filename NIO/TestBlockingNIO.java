import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : mengmuzi
 * create at:  2019-05-31  10:41
 * @description: NIO
 *  一、使用NIO 完成网络通信的三个核心：
 *  1、通道(Channel):负责连接
 *      java.nio.channels.Channel 接口：
 *      |--SelectableChannel
 *          |--SocketChannel
 *          |--ServerSocketChannel
 *          |--DatagramChannel
 *
 *          |--Pipe.SinkChannel
 *          |--Pipe.SourceChannel
 *
 *  2.缓冲区(Buffer):负责数据的存取
 *
 *  3.选择器(Selector):是 SelectableChannel 的多路复用器。用于监控SelectableChannel的IO状况
 *
 *
 */
public class TestBlockingNIO {//阻塞式NIO,没有使用selector
    //客户端
    @Test
    public void client(){
        System.out.println("client is running!!!");
        //1.获取通道
        SocketChannel sChannel = null;
        FileChannel inChannel = null;
        try {
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
            inChannel = FileChannel.open(Paths.get("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test1.jpg"), StandardOpenOption.READ);

            //2.分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3.读取本地文件，并发送给服务端
            while (inChannel.read(buf) != -1){
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭流
            if(sChannel != null){
                try {
                    sChannel.close();
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

    }

    //服务端
    @Test
    public void server(){
        System.out.println("server is running!!!");
        //1.获取通道
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;
        FileChannel outChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            outChannel = FileChannel.open(Paths.get("/Users/mengmuzi/IdeaProjects/Java_learning/NIO/test5.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            //2.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(9898));

            //3.获取客户端连接的通知
            socketChannel = serverSocketChannel.accept();

            //4.分配一个指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            //5.接受客户端的数据，并保存到本地
            while(socketChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }


        } catch (IOException e) {
            e.printStackTrace();

        }finally{
            if(serverSocketChannel != null){
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socketChannel != null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
