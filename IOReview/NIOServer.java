import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  00:51
 * @description: NIO服务端
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        // 1. serverSelector负责轮询是否有新的连接，服务端监测到新的连接之后，不再创建一个新的线程，
        // 而是直接将新连接绑定到clientSelector上，这样就不用 IO 模型中 1w 个 while 循环在死等
        Selector serverselector = Selector.open();
        // 2. clientSelector负责轮询连接是否有数据可读
        Selector clientSelector = Selector.open();
        new Thread(()->{
            try{
                // 对应IO编程中服务端启动
                //打开监听信道
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                //与本地端口绑定
                listenerChannel.socket().bind(new InetSocketAddress(3333));
                //设置为非阻塞模式
                listenerChannel.configureBlocking(false);
                //将选择器绑定到监听信道,只有非阻塞信道才可以注册选择器.并在注册过程中指出该信道可以进行Accept操作
                listenerChannel.register(serverselector, SelectionKey.OP_ACCEPT);
                while(true){
                    // 监测是否有新的连接，这里的1指的是阻塞的时间为 1ms
                    // 监听注册通道，当其中有注册的 IO 操作可以进行时，该函数返回，并将对应的 SelectionKey 加入 selected-key的set
                    if(serverselector.select(1)>0){
                        Set<SelectionKey> set = serverselector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while(keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isAcceptable()){
                                try{
                                    // (1)每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                    SocketChannel clientChannel =((ServerSocketChannel)key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector,SelectionKey.OP_READ);
                                }finally {
                                    keyIterator.remove();

                                }
                            }
                        }
                    }
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try{
                while(true){
                    // (2) 批量轮询是否有哪些连接有数据可读，这里的1指的是阻塞的时间为 1ms
                    // 监听注册通道，当其中有注册的 IO 操作可以进行时，该函数返回，并将对应的 SelectionKey 加入 selected-key的set
                    if(serverselector.select(1)>0){
                        Set<SelectionKey> set = serverselector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while(keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if(key.isReadable()){
                                try{
                                    // 每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                    SocketChannel clientChannel =((SocketChannel)key.channel());
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    //(3) 面向Buffer
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());

                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);

                                }
                            }
                        }
                    }
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

}
