import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-27  21:32
 * @description: 栈压入、弹出的序列
 */
public class IsOrNotPopOrder {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int num = pushA.length;
        int index = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <num ; i++) {
            stack.push(pushA[i]);
            while(index < popA.length && !stack.isEmpty()&& popA[index] == stack.peek()){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] pushB = {4,5,3,2,1};
        IsOrNotPopOrder is = new IsOrNotPopOrder();
        System.out.println(is.IsPopOrder(pushA,pushB));
    }
}
