/**
 * @author : mengmuzi
 * create at:  2019-04-17  14:29
 * @description: synchronized底层原理
 */
public class SynchronizedBottomPrincipleDemo {
    public void method(){
        synchronized (this){
            System.out.println("synchronized 代码块");
        }
    }
    public synchronized void method2(){
        System.out.println("synchronized 方法");
    }
}
