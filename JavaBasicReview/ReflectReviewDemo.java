import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author : mengmuzi
 * create at:  2019-04-10  16:36
 * @description: 反射的复习
 */
public class ReflectReviewDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Class<?> c = methodClass.class;
        System.out.println(c);
        Object object = c.newInstance();
        //getMethods 方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
        Method[] methods = c.getMethods();
        //getDeclaredMethods 方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] declaredMethods = c.getDeclaredMethods();
        //getMethod 方法返回一个特定的方法，其中第一个参数为方法名称，后面的参数为方法的参数对应Class的对象。
        Method method = c.getMethod("add",int.class,int.class);
        System.out.println(method);
        for (Method meth:methods) {
            System.out.print(meth + " ");
        }
        System.out.println();
        for(Method meth : declaredMethods ){
            System.out.print(meth + " ");
        }
        System.out.println();
        //我们从类中获取了一个方法后，我们就可以用 invoke() 方法来调用这个方法。
        Object result = method.invoke(object, 1,3);
        System.out.println(result);//4
        System.out.println("+++++++++++++++++++++++=");

        //利用反射创建数组；
        Class<?> cls = Class.forName("java.lang.String");
        Class<?> klass = String.class;
        //System.out.println(cls);
        //System.out.println(klass);

        //其中的Array类为java.lang.reflect.Array类
        Object array = Array.newInstance(cls,10);
        Array.set(array,0,"meng");
        Array.set(array,1,"mu");
        Array.set(array,2,"zi");
        System.out.println(Array.get(array,2));
    }

}

class methodClass{
    public final int cons = 3;
    public int add(int a ,int b){
        return a+b;
    }
    public int sub(int a ,int b){
        return a+b;
    }

}