/**
 * @author : mengmuzi
 * create at:  2019-04-19  11:11
 * @description: 锁嵌套
 */
public class DoubleSynchronized {
    //创建2个锁资源
    private static volatile Object lockA = new Object();
    private static volatile Object lockB = new Object();


    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //获取监视器锁
                    synchronized (lockA){
                        System.out.println("ThreadA get lockA!");
                        synchronized (lockB){
                            System.out.println("ThreadB get lockB!");
                            lockA.wait();
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        //创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //休眠1S
                    Thread.sleep(1000);
                    //获取lockA共享资源的监视器锁
                    synchronized (lockA){
                        System.out.println("ThreadB get lockA!");
                        System.out.println("threadB try get lockB...");
                        //获取lockB的共享资源锁
                        synchronized (lockB){
                            System.out.println("ThreadB get lockB!");
                            //线程B阻塞，并释放lockA的锁
                            System.out.println("ThreadB release lockA");
                            lockA.wait();
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start();

        //等待两个线程结束
        threadA.join();
        threadB.join();


        System.out.println("main is over!!!!");
    }


}
