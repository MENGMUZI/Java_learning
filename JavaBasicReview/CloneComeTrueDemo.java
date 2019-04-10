/**
 * @author : mengmuzi
 * create at:  2019-04-10  12:29
 * @description:
 */
public class CloneComeTrueDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTestDemo cloneTestDemo = new CloneTestDemo();
        //CloneTestDemo clone = cloneTestDemo.clone();//protected修饰符
        CloneTestDemo ctd = new CloneTestDemo();
        CloneTestDemo otherctd = ctd.clone();//抛出了 CloneNotSupportedException，这是因为 CloneTestDemo 没有实现 Cloneable 接口
    }

}
