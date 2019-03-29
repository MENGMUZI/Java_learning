/**
 * @author : mengmuzi
 * create at:  2019-03-29  15:46
 * @description: 中断一个循环线程
 */
public class InterruptedExceptionExample1 {

    public static class MyThread2 extends Thread{
        @Override
        public void run(){
            while(!interrupted()){
                System.out.println("Thread running!");
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        MyThread2 my2 = new MyThread2();
        my2.start();
        my2.interrupt();
        System.out.println("Main end");
    }

}
