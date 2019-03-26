

/**
 * @author : mengmuzi
 * create at:  2019-03-27  00:36
 * @description:输入两棵二叉树A，B，判断B是不是A的子结构
 **/
public class IsorNotSubTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if(root2 == null || root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            flag = isOrNotEqual(root1, root2);
        }//后面不能跟else,因为有可能这里flag为false还要继续判断
        if (!flag) {
            flag = HasSubtree(root1.left, root2);//一定要注意这个返回值要加上flag，因为下面还要判断
        }
        if (!flag) {
            flag = HasSubtree(root1.right, root2);
        }
        return flag;
    }

    private boolean isOrNotEqual(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 != null){
            return false;
        }
        if(root2 == null){
            return true;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isOrNotEqual(root1.left,root2.left) && isOrNotEqual(root1.right,root2.right);
    }


}
