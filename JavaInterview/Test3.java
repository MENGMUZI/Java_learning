/**
 * @author : mengmuzi
 * create at:  2019-05-04  00:31
 * @description: 局部变量的声明作用范围是在一个块内
 */
public class Test3 {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++){
            Integer integer = new Integer(i);//这里的括号不能省
        }
            System.out.println("Hello World");

    }

}
