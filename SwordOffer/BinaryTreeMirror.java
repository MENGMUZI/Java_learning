/**
 * @author : mengmuzi
 * create at:  2019-03-27  20:45
 * @description: 二叉树的镜像
 */
public class BinaryTreeMirror {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public void Mirror(TreeNode root){
        if(root == null){
            return;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);

    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }


}
