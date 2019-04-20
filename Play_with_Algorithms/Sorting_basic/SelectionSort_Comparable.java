package Sorting_basic;

/**
 * @author : mengmuzi
 * create at:  2019-04-21  01:08
 * @description: 多类型的选择排序
 */
public class SelectionSort_Comparable {
    // 我们的算法类不允许产生任何实例
    private SelectionSort_Comparable(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for (int i = 0; i <n ; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i+1; j <n; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        // 测试Integer
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort_Comparable.sort(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort_Comparable.sort(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort_Comparable.sort(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();


        //测试自定义的类Student
        Student[] students = new Student[4];
        students[0] = new Student("mengmuzi",99);
        students[1] = new Student("gumin",9);
        students[2] = new Student("muzi",79);
        students[3] = new Student("mengmu",99);
        SelectionSort_Comparable.sort(students);
        SortTestHelper.printArray(students);
    }


}
