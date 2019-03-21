/**
 * @author : mengmuzi
 * create at:  2019-03-20  20:02
 * @description: 输出链表中的倒数第K个节点
 */
public class FINDKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKTHToTail(ListNode head, int k){
        if(head == null || k <= 0){
            return null;
        }
        ListNode curr = head;
        if(k==1){ //其实不需要判K=1的情况下面已经有了
            while(curr.next !=null){
                curr = curr.next;
            }
            return curr;
        }
        ListNode before = head;
        ListNode after = head;//定义2个一前一后的节点
        for(int i =1; i < k ; i++){
            if(before.next != null){//这边要注意是before.next容易错
                before = before.next;
            }else{
                return null;
            }
        }
        while(before.next != null){
            before = before.next;
            after = after.next;
        }
        return after;
    }





}
