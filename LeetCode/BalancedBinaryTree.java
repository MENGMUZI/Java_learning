/**
 * @author : mengmuzi
 * create at:  2019-03-28  02:08
 * @description: 平衡二叉树
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean flag = Math.abs(depth(root.left)-depth(root.right))>1? false:true;
        return isBalanced(root.left) && isBalanced(root.right) && flag;
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
