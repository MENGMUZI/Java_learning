

/**
 * @author : mengmuzi
 * create at:  2019-04-10  12:27
 * @description: clone() 是 Object 的 protected 方法，它不是 public，
 * 一个类不显式去重写 clone()，其它类就不能直接去调用该类实例的 clone() 方法。
 */
public class CloneTestDemo {

    private int a;
    private int b;
    @Override
    public CloneTestDemo clone() throws CloneNotSupportedException{
        return (CloneTestDemo) super.clone();
    }



}
