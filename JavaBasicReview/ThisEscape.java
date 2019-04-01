/**
 * @author : mengmuzi
 * create at:  2019-04-01  10:04
 * @description: 模拟This逃逸
 */
public class ThisEscape {
    //final常量会保证在构造器内完成初始化（但是仅限于未发生this逃逸的情况下，具体可以看多线程对final保证可见性的实现）
    final int i;
    int j = 0;
    static ThisEscape obj;
    public ThisEscape() {
        i = 1;
        j = 1;
        //将this逃逸抛给线程B
        obj = new ThisEscape();
    }

    public static void main(String[] args) {
        //线程A：模拟构造器中this逃逸,将未构造完全对象引用抛出
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                obj = new ThisEscape();
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                ThisEscape objB = obj;
                try{
                    System.out.println(objB.j);
                }catch(Exception e){
                    System.out.println("发生空指针错误：普通变量j未被初始化");
                }
                try{
                    System.out.println(objB.i);
                }catch (Exception e){
                    System.out.println("发生空指针错误：final变量i未被初始化");
                }
            }
        });
        //threadA.start();
        threadB.start();

    }


}
