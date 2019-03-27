import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : mengmuzi
 * create at:  2019-03-27  22:26
 * @description: 从上往下打印二叉树
 */
public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
             TreeNode node = queue.poll();
             arrayList.add(node.val);
             if(node.left != null){
                 queue.offer(node.left);
             }
             if(node.right != null){
                 queue.offer(node.right);
             }

         }
         return arrayList;
    }


}
