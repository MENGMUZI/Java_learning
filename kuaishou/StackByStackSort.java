import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-08-25  20:43
 * @description:
 */
public class StackByStackSort {

    /**
     *通过两个栈如何实现排序
     * help实际上是用来存储最大值(最小值)
     * 输出结果为从小至大排序
     */

    static int i=0;

    public  static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            //peek是查看栈顶，不弹出，与pop不一样
            while(!help.isEmpty() && help.peek()> cur){
                stack.push(help.pop());
            }
            help.push(cur);
            //i++;
            //System.out.println("help-: "+help.toString());
            //System.out.println("stack--: "+stack.toString());
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s ;
        s = new Stack<>();
        s.push(1);
        s.push(5);
        s.push(3);
        s.push(4);
        s.push(2);
        s.push(5);
        s.push(3);

        sortStackByStack(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
