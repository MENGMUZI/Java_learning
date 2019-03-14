import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  19:09
 * @description: 2个队列实现一个栈
 */
public class TwoQueueStack {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueStack(){
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    //压栈
    public void push(int pushInt){
        data.add(pushInt);
    }
    //返回栈顶
    public Integer peek(){
        if(data.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        while(data.size()>1){
            help.add(data.poll());
        }
        int res = data.poll();
        //因为是只要找出这个栈顶就好了不需要出栈，所以回收这个数然后，交换两个队列
        help.add(res);
        swap();
        return res;
    }
    //出栈
    public Integer pop(){
        if(data.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        while(data.size()>1){
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;

    }

    private void swap() {
        //交换2个栈
        Queue<Integer> temp = data;
        data = help;
        help = temp;
    }
}
