import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-16  23:10
 * @description: 二叉树的前序中序后序遍历
 */
public class BinTreeRecur {

    //二叉树的前序遍历（递归）
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    //二叉树的前序遍历（递归）
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //二叉树的中序遍历（递归）
    public void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    //二叉树的后序遍历（递归）
    public void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");

    }

    //二叉树的前序遍历（非递归）利用栈结构，压头=>弹出头=>压入该节点的右和左（一直到空）=>弹出头(循环)

    public void preOrderUnRecur(Node head){
        System.out.print("pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(! stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
    //二叉树的中序遍历（非递归）
    public void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            while (! stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    //二叉树的后序遍历（非递归）
    public void posOrderUnRecur(Node head){
        System.out.println("pos-order:");
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(! stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);//不打印压入另一个栈中
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while(! stack2.isEmpty()) {
                System.out.println(stack2.pop() + " ");
            }
        }
        System.out.println();
    }

}
