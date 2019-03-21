/**
 * @author : mengmuzi
 * create at:  2019-03-21  09:27
 * @description: 合并两个排序的链表
 */
public class MergeTwoList {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge (ListNode list1, ListNode list2){
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);//合成新节点的首节点
        ListNode curr = head;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                curr.next = list2;
                list2 = list2.next;
            }else{
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        /*
        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        */

        if(list1 != null){
            curr.next = list1;
        }
        if(list2 != null){
            curr.next = list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(7);
        list1.next.next.next = new ListNode(10);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(13);
        list2.next.next = new ListNode(14);
        list2.next.next.next = new ListNode(14);

        ListNode newhead = Merge(list1,list2);
        while(newhead!= null){
            System.out.println(newhead.val);
            newhead = newhead.next;
        }

    }

}
