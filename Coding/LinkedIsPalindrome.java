

import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-15  16:18
 * @description: 判断链表是不是回文结构
 */
public class LinkedIsPalindrome {
        class Node{
            public int data;
            public Node next;
            public Node(int data){
                this.data = data;
            }
        }
        /*
        //方法一：
        public boolean isPalindrome1(Node head){
            //将链表中的节点压入栈中，然后出栈比较原结构
            Stack<Node> stack = new Stack<Node>();
            while(head != null){
                stack.push(head);
                head = head.next;
            }
            //依次比较
            while(head != null){
                if(head.data != stack.pop().data) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }
        //方法二：一个快指针，一个慢指针来遍历链表。快指针每次走两步，慢指针每次走一步。等到快指针遍历完链表，慢指针就正好停留在链表的中央。

        public boolean isPalindrome2(Node head){
            if(head == null || head.next == null){
                return true;
            }
            Node slow = head.next;//慢指针，一次动一格,这是他们初始点
            Node fast = head;//快指针，一次动两格
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Stack<Node> stack = new Stack<Node>();
            while(slow != null){
                stack.push(slow);
                slow = slow.next;
            }
            while(!stack.empty()){
                if(head.data != stack.pop().data){
                    return false;
                }
                head = head.next;  //这句别忘了！！！！！！
            }
            return true;
        }
        */
        //方法三：右边半区链表反转
        public boolean isPalindrome3(Node head){
            if(head == null || head.next == null){
                return true;
            }
            Node slow = head;//因为需要右半边第一个点的前一个节点，所以这里使用head而不是head.next,求出的慢指针是和上题偏差一个
            Node fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            //下面和单向链表反转一样
            Node R1 = slow.next;//右半边的第一个点
            Node R1Next = null;
            while(R1 != null){
                R1Next = R1.next;
                R1.next = slow;
                slow = R1;
                R1 = R1Next;
            }
            //比较大小
            Node RL = slow; //slow是右边的最后一个点
            Node LR= head;//左边第一个点
            boolean res = true;
            while(RL != null && LR != null){
                if(RL.data != LR.data){
                    res = false;
                    break;
                }
                RL = RL.next;
                LR = LR.next;
            }
            //将列表恢复
            Node next = null;
            Node pre = null;
            while(slow != null){
                next = slow.next;
                slow.next = pre;
                pre = slow;
                slow = next;
            }
            return res;
        }





}
