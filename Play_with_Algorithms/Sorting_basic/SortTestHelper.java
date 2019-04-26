package Sorting_basic;

import java.lang.reflect.Method;

/**
 * @author : mengmuzi
 * create at:  2019-04-21  00:26
 * @description: 随机生成数组
 */
public class SortTestHelper {
    // SortTestHelper不允许产生任何实例
    private SortTestHelper(){}

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = new Integer((int)(Math.random()*(rangeR-rangeL+1)+rangeL));//注意扩号的问题
        }
        return arr;
    }

    //打印arr数组的所有内容
    public static void printArray(Object[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    //判断arr数组是否有序
    public static boolean isSort(Comparable[] arr){
        for (int i = 0; i <arr.length-1; i++) {
            if(arr[i].compareTo(arr[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    //测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr){
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            /**
             * Method Class.getMethod(String name, Class<?>... parameterTypes)的作用是获得对象所声明的公开方法
             * 该方法的第一个参数name是要获得方法的名字，第二个参数parameterTypes是按声明顺序标识该方法形参类型。
             *
             *如一个函数 int Test(int a, String str);
             *
             * 对应的getMethod方法：
             *
             * 1.  getMethod("Test",int.class,String.class);
             *
             * 2. getMethod("Test",new Class[]{int.class,String.class});
             * ---------------------
            * */
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            //排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            //调用排序函数
            //invoke的一个参数是null，因为这是静态方法，不需要借助实例运行。
            /**
             * method.invoke(owner, args)：执行该Method.invoke方法的参数是执行这个方法的对象owner，和参数数组args，
             * 可以这么理解：owner对象中带有参数args的method方法。返回值是Object，也既是该方法的返回值。
             */
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();
            assert isSort(arr);
            System.out.println(sortClass.getSimpleName() + ":" + (endTime-startTime) + "ms" );

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
