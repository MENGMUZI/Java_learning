/**
 * @author : mengmuzi
 * create at:  2019-03-14  15:42
 * @description: 数组实现队列结构
 */
public class ArrayQueue {

    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayQueue(int initSize){

        if(initSize < 0){
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }
    public Integer peak(){
        if(size == 0){
            return null;
        }
        return arr[start];
    }
    public void push(int Obj){
        if(size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size ++;
        end = end == arr.length-1 ? 0 : end + 1;
    }
    public Integer pop(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size --;
        int temp = start;//现在的位置才是真正的位置
        start = start == arr.length-1 ? 0 : start +1;
        return arr[temp];

    }
}



