import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  20:10
 * @description: 2个栈结构变成队列
 */
public class TwoStackQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }
    //进队
    public void add(int pushInt){
        stackPush.push(pushInt);
    }
    //出队
    public int poll(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }else if (stackPop.isEmpty()){
            while(! stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    //队列的顶端
    public int peek(){
        if(stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }else if (stackPop.isEmpty()){
            while(! stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
