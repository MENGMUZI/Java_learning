/**
 * @author : mengmuzi
 * create at:  2019-03-28  01:44
 * @description: 二叉树的高度
 */

/*
* 第104题，思路：树是一种递归的定义：一棵树要么是空树，要么有两个指针，每个指针指向一棵树。
* 因此很多树相关的问题都能用递归的方式求解。
* */
public class MaxDepthBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
