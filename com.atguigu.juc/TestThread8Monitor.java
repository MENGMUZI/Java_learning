import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-25  14:50
 * @description: 线程8锁
 * 题目：判断打印的"one"and"two"?
 * 1.两个普通同步方法(synchronized)，两个线程，标准打印 //one two
 * 2.新增Thread.sleep() 给getOne()打印 // one two
 * 3.新增普通方法getthree()，打印 // three one two
 * 4.两个普通同步方法，两个number对象，打印 //two one
 * 5.修改getOne()为静态同步方法，打印 // two one
 * 6.修改两个同步方法均为静态同步方法，打印 // one two
 * 7.一个是静态另一个非静态，两个Number对象 //two one
 * 8.两个静态同步方法，两个number对象 // one two
 *
 *
 * 线程八锁关键：
 *  1.静态方法的锁为对应的Class实例，非静态方法的锁默认为this
 *  2.在某时刻内只有一个线程持有锁，无论几个方法。
 */
public class TestThread8Monitor {
    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();
        new Thread(()->{
            number.getOne();
        },"t1").start();

        new Thread(()->{
            //number.getTwo();
            number2.getTwo();
        },"t2").start();

        /*new Thread(()->{
            number.getThree();
        },"t3").start();*/
    }
}
class Number{
    public static synchronized void getOne(){
        //暂停一会儿线程
        try{ TimeUnit.SECONDS.sleep(2);}catch(Exception e){e.printStackTrace();}
        System.out.println("one");
    }
    public static synchronized void getTwo(){
        System.out.println("two");
    }

    public void getThree(){
        System.out.println("three");
    }

}
