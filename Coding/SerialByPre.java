import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-17  15:55
 * @description: 先序遍历二叉树实现序列化和反序列化
 */
public class SerialByPre {

    public class Node{
        public int value;
        public Node right;
        public Node left;
        public Node(int value){
            this.value = value;
        }
    }
    //序列化递归
    public String serialByPre(Node head){
        if(head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
    //序列化非递归
    public String serialByPreUnRecur(Node head){
        String res = null;
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                res += head.value+"!";
                if(head.right == null){
                    res += "#!";
                }else{
                    stack.push(head.right);
                }
                if(head.left == null){
                    res += "#!";
                }else{
                    stack.push(head.left);
                }
            }
        }
        return res;
    }

    //递归反序列化
    public Node deSerialByPreString(String preStr){
        String[] arr = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i <arr.length ; i++) {
            queue.offer(arr[i]);
        }
        return deSerialByRecur(queue);

    }

    private Node deSerialByRecur(Queue<String> queue) {
        String value = queue.poll();
        if(value.equals("#")){
            return  null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = deSerialByRecur(queue);
        head.right = deSerialByRecur(queue);
        return head;
    }


}
