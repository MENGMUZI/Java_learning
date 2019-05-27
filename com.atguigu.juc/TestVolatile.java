import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-24  01:03
 * @description: volatile关键字:保证内存中的数据可见
 *               相当于synchronized是一种较为轻量级的同步策略
 * 注意： 1.volatile不具备"互斥性"
 *       2.不保证变量的原子性
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while(true){
            if(td.isFlag()){
                System.out.println("main thread is working------------------");
                break;
            }
        }
    }

}
class ThreadDemo implements Runnable{
    private volatile boolean flag = false;
    @Override
    public void run() {
        //暂停一会儿线程
        try{ TimeUnit.SECONDS.sleep(2);}catch(Exception e){e.printStackTrace();}
        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
