import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-03-21  15:36
 * @description: 对称的二叉树
 */
public class IsSymmetricalTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //方法一：递归的方法
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        return boolSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean boolSymmetrical(TreeNode left, TreeNode right) {
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return(boolSymmetrical(left.left,right.right) && boolSymmetrical(left.right,right.left));
    }

    //方法二：使用栈或者队列，把需要比较的两个节点压入栈，再比较
    /*
        * DFS使用stack来保存成对的节点
        * 1.出栈的时候也是成对成对的 ，
                   1.若都为空，继续；
                   2.一个为空，返回false;
                   3.不为空，比较当前值，值不等，返回false；
        * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.right,right.left
    */
    boolean isSymmetrical1(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while(!stack.isEmpty()){
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if(n1 == null && n2 == null){
                continue;
            }
            if(n1 == null || n2 == null || n1.val != n2.val){
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);

        }
        return true;
    }

  /*
     * BFS使用Queue来保存成对的节点，代码和上面极其相似
     * 1.出队的时候也是成对成对的
               1.若都为空，继续；
               2.一个为空，返回false;
               3.不为空，比较当前值，值不等，返回false；
     * 2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.right,right.left
     */
    boolean isSymmetrical2(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while(! queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if(n1 == null && n2 == null){
                continue;
            }
            if(n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.left);
            queue.offer(n2.right);
        }
        return true;
    }

}
