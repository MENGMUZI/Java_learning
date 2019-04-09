import java.util.Arrays;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  13:18
 * @description: Arrays.asList()方法的使用
 */
public class ArraysAsListReviewDemo {

    public static void main(String[] args) {
        /*段落一:基本数据类型使用asList的问题   */

        /* 说明:虽然在jdk1.6中能够将基本数据类型的数组转换成List,但还是有个缺陷   */
        int[] a = {1,4,6,8,2,3,7,9};
        List list = Arrays.asList(a);
        System.out.println(list);//[[I@2752f6e2]
        /*预期输出应该是在1,4,6,8,2,3,7,9 但实际上输出的仅仅是一个引用,这里它把a 当成一个元素*/
        for (Object element:list) {
            System.out.print(element);
        }
        System.out.println();//[I@2752f6e2
        int[] b = (int[]) list.get(0);
        for (Object element: b) {
            System.out.print(element);
        }
        System.out.println();

        /*段落二：对象类型的数组使用asList，是我们预期的 */
        Integer[]  a_new = new Integer[]{1,4,6,8,2,3,7,9};
        List<Integer> list_new = Arrays.asList(a_new);
        System.out.println(list_new);

        /*段落三:当更新数组或者asList之后的List,另一个将自动获得更新*/
        // asList得到的数组是的没有add和remove方法的
        /*list_new.add(2019);
        for (int element:list_new) {
            System.out.print(element);
        }
        System.out.println();//java.lang.UnsupportedOperationException*/
        a_new[3] = 1;
        for (int element:list_new) {
            System.out.print(element);
        }
        System.out.println();

    }

}
