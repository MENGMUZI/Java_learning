import java.sql.Array;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  15:20
 * @description: 数组实现栈结构
 */
public class ArrayStack {

    private Integer[] arr;
    private Integer index;

    public ArrayStack(int initSize){
        if(initSize < 0){
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }
    //返回栈顶
    public Integer peak(){
        if(index == 0){
            return null;
        }
        return arr[index-1];
    }

    //压栈
    public void push(int obj){
        if(index == arr.length){
            throw new ArrayIndexOutOfBoundsException("溢出");
        }
        arr[index ++] = obj;
    }
    //出栈
    public Integer pop(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("空栈");
        }
        return arr[--index];
    }

}
