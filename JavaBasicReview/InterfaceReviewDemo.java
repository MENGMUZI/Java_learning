/**
 * @author : mengmuzi
 * create at:  2019-04-09  23:52
 * @description: 在 Java 8 之前，它可以看成是一个完全抽象的类，
 * 也就是说它不能有任何的方法实现。  从 Java 8 开始，接口也可以拥有默认的方法实现，
 * 这是因为不支持默认方法的接口的维护成本太高了。
 */
public interface InterfaceReviewDemo {

    void func1();

    default void func2(){
        System.out.println("接口的成员（字段 + 方法）默认都是 public 的，并且不允许定义为 private 或者 protected。");
    }
    int meng = 4;

    public int func3();
    //private void func4();  报错
    //protected void func5(); 不允许

    int 想= 123;
    //int y ; Variable 'y' might not have been initialized
    public int h = 12123;
    // private int k = 0;   // Modifier 'private' not allowed here
    // protected int l = 0; // Modifier 'protected' not allowed here
    // private void fun3(); // Modifier 'private' not allowed here

}
