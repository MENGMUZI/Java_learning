/**
 * @author : mengmuzi
 * create at:  2019-03-20  01:47
 * @description: 用两个栈实现队列
 */

import java.util.Stack;

public class TwoStackToArray {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack2.isEmpty()){
            while(! stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
