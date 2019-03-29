/**
 * @author : mengmuzi
 * create at:  2019-03-29  14:25
 * @description: 调用一个线程的 interrupt() 来中断该线程
 */
public class InterruptedExceptionExample {

    public static class MyThread1 extends Thread{
        @Override
        public void run(){
            try {
                //Thread.sleep(2000);
                wait();

                System.out.println("Thread run");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        mt.start();
        mt.interrupt();
        System.out.println("Main run");
    }

}
