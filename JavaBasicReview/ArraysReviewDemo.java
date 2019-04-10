import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  11:26
 * @description: Arrays类的常见操作
 */
public class ArraysReviewDemo {

    public static void main(String[] args) {
        arraysShowI();
    }

    private static void arraysShowI() {
        //排序
        //int a[] = {1,3,5,7,2,4,56,2};
        String a[] = {"meng","mu","zi","gu"};
        Arrays.sort(a);
        System.out.println(a);
        for (String element: a) {
            System.out.print(element);
        }
        System.out.println();
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(a);
        for (String element: a) {
            System.out.print(element);
        }
        System.out.println();

        //sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
        int b[] = {1,3,5,7,2,4,56,2};
        Arrays.sort(b,1,5);
        for (int element: b) {
            System.out.print(element);
        }
        System.out.println();

        // parallelSort(int[] a) 按照数字顺序排列指定的数组。同sort方法一样也有按范围的排序
        int c[] = {1,3,5,7,2,4,56,2};
        Arrays.parallelSort(c);
        for (int i = 0; i <c.length ; i++) {
            System.out.print(c[i]);
        }
        System.out.println();

        //对字符串排序的情况,Arrays.sort() 对每个字符串的特定位置进行比较，然后按照升序排序。
        String[] strs = {"abcdehg", "abcdefg", "abcdeag"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        String[] strs1 = {"127.0.0.1","192.168.1.1","192.167.2.1","192.168.2.1"};
        Arrays.sort(strs1);
        System.out.println(Arrays.toString(strs1));

        //查找 binarySearch()
        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(Arrays.binarySearch(e,'c'));
        int f[] = {1,3,5,7,2,4,56,2,2,3};
        Arrays.sort(f);
        System.out.println(Arrays.binarySearch(f,3));

        //比较
        char[] j = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        char[] k = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(j.equals(k));//false
        System.out.println(Arrays.equals(j,k));//true

        //填充
        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        Arrays.fill(h,0);
        for (int element: h) {
            System.out.print(element);
        }
        System.out.println();

        // 数组中指定范围元素重新分配值
        int[] l = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        Arrays.fill(l,0,2,5);
        for (int element: l) {
            System.out.print(element);
        }
        System.out.println();

        //转列表
        /*
         * 返回由指定数组支持的固定大小的列表。
         * （将返回的列表更改为“写入数组”。）该方法作为基于数组和基于集合的API之间的桥梁，与Collection.toArray()相结合 。
         * 返回的列表是可序列化的，并实现RandomAccess 。
         * 此方法还提供了一种方便的方式来创建一个初始化为包含几个元素的固定大小的列表如下：
         */
        int y[] = {1,3,5,7,2,4,56,2,2,3};
        List list = Arrays.asList(y);
        System.out.println(list);//[[I@58ceff1]

        //转字符串
        int z[] = {1,3,5,7,2,4,56,2,2,3};
        System.out.println(Arrays.toString(z));//[1, 3, 5, 7, 2, 4, 56, 2, 2, 3]


        String subStr = Arrays.toString(z).substring(1);
        System.out.println(subStr);

        //复制 copyOf 方法实现数组复制,h为数组，6为复制的长度
        int m[] = {1,3,5,7,2,4,56,2,2,3};
        int n[] = Arrays.copyOf(m,6);
        for (int element: n) {
            System.out.print(element);
        }
        System.out.println();



    }

}
