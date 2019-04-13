import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author : mengmuzi
 * create at:  2019-04-12  17:52
 * @description: BIO通信（一请求一应答）模型，客户端
 */
public class BIOClient {
    public static void main(String[] args) {
        //TODO 创建多个线程，模拟多个客户端连接服务器
        new Thread(()->{
            try{
                Socket socket = new Socket("127.0.0.1",3333);
                System.out.println("客户端已经启动");
                while(true){
                    try{
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

}
