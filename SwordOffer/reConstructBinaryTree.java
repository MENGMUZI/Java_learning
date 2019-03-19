/**
 * @author : mengmuzi
 * create at:  2019-03-20  00:50
 * @description: 重建二叉树
 *
 * 题目分析：前序遍历的第一个节点肯定是树根，中序遍历中的根节点将左右子树分开，
 * 所以使用递归重建左右子树
 */
public class reConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int[] pre , int[] in ){
        TreeNode root = findRoot(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    public TreeNode findRoot(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){

        if(startPre>endPre||startIn>endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn ; i++) {
            if(in[i] == pre[startPre]){
                root.left=findRoot(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=findRoot(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }


}
