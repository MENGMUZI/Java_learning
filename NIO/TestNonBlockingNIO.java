import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-05-31  16:22
 * @description:  非阻塞NIO
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
 */
public class TestNonBlockingNIO {//非阻塞式

    //客户端
    @Test
    public void client(){
        //System.out.println("client is running !!!!!!!!!");
        //System.out.println();
        SocketChannel sChannel = null;
        try {
            //1.获取通道
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

            //2.切换成非阻塞模式
            sChannel.configureBlocking(false);

            //3.分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //4.发送数据给服务端
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String str = scanner.next();
                buf.put((LocalDateTime.now().toString() + "\n" + str).getBytes());
                buf.flip();
                sChannel.write(buf);//从给定的缓冲区向该通道写入一个字节序列。
                buf.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            //5.关闭通道
            if(sChannel != null){
                try {
                    sChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //服务端
    @Test
    public void server(){
        //System.out.println("server is running !!!!!!!!!");
        //System.out.println();
        ServerSocketChannel ssChannel = null;
        SocketChannel sChannel = null;
        try {
            //1.获取通道
            ssChannel = ServerSocketChannel.open();

            //2.切换非阻塞模式
            ssChannel.configureBlocking(false);

            //3.绑定连接
            ssChannel.bind(new InetSocketAddress(9898));

            //4.获取选择器
            Selector selector = Selector.open();

            //5.将通道注册到选择器上,并指定"监听事件"（接收事件）
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);

            //6.轮询式的获取选择器上"准备就绪"的事件
            while(selector.select() > 0){
                //7. 获取当前选择器中所有注册的" 选择键（已就绪的监听状态）"
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    //8.获取准备就绪的事件
                    SelectionKey sk = iterator.next();

                    //9.判断是什么事件准备就绪
                    if(sk.isAcceptable()){

                        //10.若接收就绪，获取客户端连接
                        sChannel = ssChannel.accept();

                        //11.切换客户端非阻塞模式
                        sChannel.configureBlocking(false);

                        //12.将该通道注册到选择器上
                        sChannel.register(selector,SelectionKey.OP_READ);

                    }else if(sk.isReadable()){
                        //13.获取当前选择器上读就绪状态的通道
                        sChannel = (SocketChannel) sk.channel();

                        //14.读取数据
                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        int len = 0;
                        while((len = sChannel.read(buf)) != -1){
                            buf.flip();
                            System.out.println(new String(buf.array(),0,len));
                            buf.clear();
                        }

                    }
                    //15.取消选择键SelectionKey
                    iterator.remove();
                }

            }

        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            if(sChannel != null){
                try {
                    sChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ssChannel != null){
                try {
                    ssChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
