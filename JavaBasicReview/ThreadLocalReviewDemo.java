/**
 * @author : mengmuzi
 * create at:  2019-04-01  16:34
 * @description: java.lang.ThreadLocal 类来实现线程本地存储功能。
 */
public class ThreadLocalReviewDemo {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(()->{
            threadLocal.set(1);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(()->{
           threadLocal.set(2);
           threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }

}
