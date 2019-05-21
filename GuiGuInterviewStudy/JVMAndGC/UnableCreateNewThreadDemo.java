package JVMAndGC;

import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  22:18
 * @description:  unable to create new native thread
 *                经常出现在高并发请求服务器
 */
public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {
        for (int i = 1;  ; i++) {
            System.out.println("**************i=" + i);
            new Thread(()->{
                //暂停一会儿线程
                try{ TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);}catch(Exception e){e.printStackTrace();}
            },String.valueOf(i)).start();
        }
        //Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
    }

}
