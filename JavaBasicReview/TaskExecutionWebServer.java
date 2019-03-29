import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-03-29  00:36
 * @description: 线程池的WEB服务器
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;
    private static final Executor exc = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(80);
        while(true){
            final Socket connection = ss.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //handleRequest(connection);
                }
            };
            exc.execute(task);
        }
    }

}
class ThreadPerTaskExecutor implements Executor{
    Runnable r = new Runnable() {
        @Override
        public void run() {
            //todo
        }
    };
    @Override
    public void execute(Runnable r){
        new Thread(r).start();
    }
}
