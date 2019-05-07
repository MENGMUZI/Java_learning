/**
 * @author : mengmuzi
 * create at:  2019-05-07  20:35
 * @description: 单例模式
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo()");
    }
    /**
     * 1.并发模式下以前的单例模式会出现问题，加synchronized 可以解决，但是锁的粒度太大
     * 2. 采用DCL机制（Double Check Lock 双端检锁机制）
     * */
    // 1.采用synchronized
    public static synchronized SingletonDemo getInstance(){
        if(instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }
    // 2.DCL机制
    public static SingletonDemo getInstanceByDCL(){
        //要加volatile防止重排序
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        //单线程（main线程操作）

        /*
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        */

        //并发多线程，情况不一样
        for (int i = 1; i <= 10 ; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }


    }

}
