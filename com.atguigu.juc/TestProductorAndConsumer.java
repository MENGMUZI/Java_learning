import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  00:07
 * @description: 生产者消费者案例（重要）
 */
public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        MyProductor mp = new MyProductor(clerk);
        MyConsumer mc = new MyConsumer(clerk);
        new Thread(mp,"生产者A").start();
        new Thread(mp,"生产者B").start();
        new Thread(mc,"消费者A").start();
        new Thread(mc,"消费者B").start();

    }
}
//店员
class Clerk{
    private int product = 0;

    //进货
    public synchronized void get(){
        while(product >= 1){//防止虚假唤醒
            System.out.println("产品已经满了！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + (++product));
        notifyAll();
    }
    //卖货
    public synchronized void sale(){
        while(product <= 0){
            System.out.println("缺货！");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + (--product));
        notifyAll();
    }

}
//生产者
class MyProductor implements Runnable{
    private Clerk clerk ;
    public MyProductor(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            clerk.get();
        }
    }
}
//消费者
class MyConsumer implements Runnable{
    private Clerk clerk;

    public MyConsumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            //暂停一会儿线程
            try{ TimeUnit.MILLISECONDS.sleep(200);}catch(Exception e){e.printStackTrace();}
            clerk.sale();
        }
    }
}
