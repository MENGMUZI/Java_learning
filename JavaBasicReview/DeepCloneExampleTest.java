/**
 * @author : mengmuzi
 * create at:  2019-04-10  13:50
 * @description: 深拷贝
 */
public class DeepCloneExampleTest implements Cloneable {

    private int[] arr;

    public DeepCloneExampleTest(){
        arr = new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }
    }

    public void set(int index , int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    @Override
    protected DeepCloneExampleTest clone() throws CloneNotSupportedException {
        DeepCloneExampleTest result = (DeepCloneExampleTest) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DeepCloneExampleTest e1 = new DeepCloneExampleTest();
        DeepCloneExampleTest e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2));//2
    }


}
