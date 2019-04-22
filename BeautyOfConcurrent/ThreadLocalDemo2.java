/**
 * @author : mengmuzi
 * create at:  2019-04-20  00:17
 * @description: threadlocal 不支持继承性
 * 因为在子线程 thread 里面调用 get方法时当前线程 为 thread线程，
 * 而这里调用 set方法设置线程变量的是 main线程，两者是不同的线程，
 * 自然子线程访问时返回 null。
 */
public class ThreadLocalDemo2 {

    //创建线程变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //设置线程变量
        threadLocal.set("hello world");
        //启动子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程输出线程变量值
                System.out.println("thread:" + threadLocal.get());
            }
        });
        thread.start();
        //主线程输出线程变量值
        System.out.println("main:" + threadLocal.get());
    }

}
