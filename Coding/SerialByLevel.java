import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : mengmuzi
 * create at:  2019-03-21  17:05
 * @description: 二叉树按层遍历,序列化和反序列化
 */
public class SerialByLevel {
    public class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        public Node(int data) {
            this.data = data;

        }

    }
    //按层遍历，序列化
    public String serialByLevel(Node head){
        if(head == null){
            return "#!";
        }
        String res = head.data + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while(! queue.isEmpty()){
            head = queue.poll();
            if(head.left != null){
                res += head.left.data + "!";
                queue.offer(head.left);
            }else{
                res += "#!";
            }
            if(head.right != null){
                res += head.right.data + "!";
                queue.offer(head.right);
            }else{
                res += "#!";
            }
        }
        return res;
    }
    //按层遍历，反序列化
    public Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if(head != null){
            queue.offer(head);
        }
        Node node = null;
        while(! queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return head;
    }

    private Node generateNodeByString(String value) {
        if(value.equals("#")){
            return null;
        }
        return new Node(Integer.parseInt(value));
    }


}
