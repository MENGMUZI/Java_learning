import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-19  22:50
 * @description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
       }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack();
        ArrayList<Integer> al = new ArrayList<Integer>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            al.add(stack.pop().val);
        }
        return al;
    }

}
