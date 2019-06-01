import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-06-01  11:30
 * @description: NIO DatagramChannel
 */
public class TestNonBlockingNIO2 {
    @Test
    public void send(){
        DatagramChannel dc = null;
        try {
            dc = DatagramChannel.open();
            dc.configureBlocking(false);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String str = scanner.next();
                buf.put((LocalDateTime.now().toString() + "\n" + str ).getBytes());
                buf.flip();
                dc.send(buf,new InetSocketAddress("127.0.0.1",9898));
                buf.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if(dc != null){
                try {
                    dc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void receive(){
        DatagramChannel dc = null;
        try {
            dc = DatagramChannel.open();

            dc.configureBlocking(false);

            dc.bind(new InetSocketAddress(9898));

            Selector selector = Selector.open();

            dc.register(selector, SelectionKey.OP_READ);

            while (selector.select() > 0){
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while(iterator.hasNext()){
                    SelectionKey sk = iterator.next();

                    if(sk.isReadable()){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                        dc.receive(byteBuffer);

                        byteBuffer.flip();

                        System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));

                        byteBuffer.clear();
                    }
                    iterator.remove();
                }

            }
        } catch (IOException e) {

            e.printStackTrace();

        }finally {
            if(dc != null){
                try {
                    dc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
