/**
 * @author : mengmuzi
 * create at:  2019-04-19  21:23
 * @description:通过 set 方法设置了 localVariable 的值，
 * 这其实设置的是线程 One 本地内存中的 一个副本，
 * 这个副本线程 Two 是访问不了的 。
 * 然后代码 3.2 调用了 print 函数，
 * 代码 1.1 通过 get 函数获取了 当前线程(线程 One)本地内存中 localVariable 的值 。
 *
 *
 * 总结：
 * 在每个线程内部都有一个名为threadLocals 的成员变量，
 * 该变量的类型为HashMap，其中key为我们定义的ThreadLocal变量的this引用，
 * value则为我们使用set方法设置的值。
 */
public class ThreadLocalDemo {

    //打印函数
    static void print(String str){
        //打印当前线程本地内存中 localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        //清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    //创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程中本地变量ThreadLocal的值
                localVariable.set("threadA local variable");
                //调用打印函数
                print("threadA");
                //打印本地变量值
                System.out.println("threadA remove after" + ":" + localVariable.get());
            }
        });

        //创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //设置线程中本地变量ThreadLocal的值
                localVariable.set("threadB local variable");
                //调用打印函数
                print("threadB");
                //打印本地变量值
                System.out.println("threadB remove after" + ":" + localVariable.get());
            }
        });

        //启动线程
        threadA.start();
        threadB.start();
    }



}
