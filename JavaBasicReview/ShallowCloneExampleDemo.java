/**
 * @author : mengmuzi
 * create at:  2019-04-10  12:52
 * @description: 浅拷贝
 */
public class ShallowCloneExampleDemo implements Cloneable {

    private int[] arr;
    public ShallowCloneExampleDemo(){
        arr = new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i;
        }
    }

    public void set(int index,int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    @Override
    protected ShallowCloneExampleDemo clone() throws CloneNotSupportedException {
        return (ShallowCloneExampleDemo) super.clone();
    }

}
