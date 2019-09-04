/**
 * @author : mengmuzi
 * create at:  2019-09-04  18:59
 * @description:
 */

import java.util.Scanner;

public class Trip001 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode small = null;
        ListNode big = null;
        ListNode smallLast = null;
        ListNode bigLast = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val <= m){
                ListNode next = cur.next;
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                smallLast = cur;
                cur = next;
            }else{
                ListNode next = cur.next;
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
                cur = next;
            }
        }
        if(small == null){
            return big;
        }else{
            smallLast.next = big;
            if(bigLast != null){
                bigLast.next = null;
            }
            return small;
        }


    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}

