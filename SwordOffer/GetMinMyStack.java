import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-27  01:42
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 */
public class GetMinMyStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }
        int num = node > stack2.peek()? stack2.peek() : node;
        stack2.push(num);
    }
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    public int top() {
        return stack1.peek();
    }
    public int min() {
        return stack2.peek();
    }


}
