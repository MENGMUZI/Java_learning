import java.util.HashMap;

/**
 * @author : mengmuzi
 * create at:  2019-03-15  21:24
 * @description: 复制含有随机节点的链表
 */
public class CopyListWithRand {



    //方法一：利用hashmao
    public Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node curr = head;
        while(curr != null){
            map.put(head,new Node(curr.data));
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).rand = map.get(curr.rand);
            curr = curr.next;
        }
        return map.get(head);
    }

    //方法二：将生成的copy节点插入原来节点的中间
    public Node copyListWithRand2(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        Node next = null;
        //复制并连接每一个节点
        while(curr != null){
            next = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = next;
            curr = curr.next;
        }
        curr = head;
        Node currCopy = null;
        while(curr != null){
            next = curr.next.next;
            currCopy = curr.next;
            currCopy.rand = curr.rand == null ? null : curr.rand.next;
            curr = next;
        }
        Node res = head.next;//记录一下copy的头节点
        curr = head;
        while(curr != null){
            next = curr.next.next;
            currCopy = curr.next;
            curr.next = next;
            currCopy.next = next != null ? next.next : null;
            curr = next;
        }
        return res;
    }

}
