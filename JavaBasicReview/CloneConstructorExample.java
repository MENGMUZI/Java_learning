/**
 * @author : mengmuzi
 * create at:  2019-04-10  14:16
 * @description: 使用拷贝构造函数或者拷贝工厂来拷贝一个对象。
 */
public class CloneConstructorExample {

    private int[] arr;
    public CloneConstructorExample(){
        arr = new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }
    }
    public CloneConstructorExample(CloneConstructorExample original){
        arr = new int[original.arr.length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = original.arr[i];

        }
    }
    public void set(int index, int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public static void main(String[] args) {
        CloneConstructorExample cce = new CloneConstructorExample();
        CloneConstructorExample cce2 = new CloneConstructorExample(cce);
        cce.set(2,222);
        System.out.println(cce2.get(2));//2
    }

}
