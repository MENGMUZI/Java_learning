import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  16:42
 * @description: 设计一个有getMin功能的栈
 */
public class GetMinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack(){
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if(stackMin.empty()){
            stackMin.push(newNum);
        }else if (newNum < getmin()){
            stackMin.push(newNum);
        }else{
            stackMin.push(getmin());
        }
        stackData.push(newNum);
    }

    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        stackMin.pop();
        return stackData.pop();

    }

    public int getmin(){
        if(stackMin.empty()){
            throw new RuntimeException("Your stack is empty!");
        }
        return stackMin.peek();
    }


}
