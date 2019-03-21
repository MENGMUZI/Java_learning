/**
 * @author : mengmuzi
 * create at:  2019-03-21  13:34
 * @description: 复杂链表的复制
 */
public class RandomListNodeClone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        RandomListNode curr = pHead;
        //在后面复制一个copy
        while(curr != null){
            RandomListNode next = curr.next;//原来节点的下一个节点
            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        //连接他们的random节点
        curr = pHead;
        while(curr != null){
            RandomListNode next = curr.next.next;
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr = next;
        }
        //整理复制的节点
        curr = pHead;
        RandomListNode res = curr.next;
        while(curr != null){
            RandomListNode next = curr.next.next;
            RandomListNode copy = curr.next;
            curr.next = next;
            copy.next = next != null ? next.next : null;
            curr = next;
        }
        return res;

    }

}
