/**
 * @author : mengmuzi
 * create at:  2019-04-07  11:06
 * @description: 静态内部类类加载的顺序
 */
public class Outer {
    static {
        System.out.println("load out class .....");
    }
    //静态内部类
    static class StaticInnner{
        static{
            System.out.println("load static inner class......");
        }

        static void staticInnerMethod(){
            System.out.println("static inner method......");
        }

    }
    public static void main(String[] args){
        Outer outer = new Outer();
        System.out.println("》》》》》》》》》》》》》》");
        StaticInnner.staticInnerMethod();
    }

}
