/**
 * @author : mengmuzi
 * create at:  2019-04-24  11:03
 * @description: 重排序
 */
public class ReRange {
    private static int num = 0;
    private static boolean ready = false;
    public static class ReadThread extends Thread{
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                if(ready){
                    System.out.println(num+num);
                }
                System.out.println("read thread .....");
            }
        }
    }

    public static class WriteThread extends Thread{
        @Override
        public void run(){
            num = 2;
            ready = true;
            System.out.println("writeThread set over...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();
        WriteThread wt = new WriteThread();
        wt.start();
        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main is over!");
    }
}
