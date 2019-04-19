/**
 * @author : mengmuzi
 * create at:  2019-04-19  14:27
 * @description: 等待线程执行终止的 join 方法
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread threadone = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("threadone is over!!!");
            }

        });

        Thread threadtwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("threadtwo is over!!");
            }

        });

        //启动子线程
        threadone.start();
        threadtwo.start();
        System.out.println("wait all child thread over!!!");

        //等待子线程执行完毕，返回
        threadone.join();
        threadtwo.join();

        System.out.println("all child thread over!!!");
    }

}
