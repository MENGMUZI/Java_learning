import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : mengmuzi
 * create at:  2019-03-20  21:28
 * @description: 序列化和反序列化二叉树
 */
public class SerializeAndDeSerialize {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //前序遍历序列化
    String Serialize(TreeNode root){
        if(root == null){
            return "#!";
        }
        String res = root.val + "!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }
    //前序遍历反序列化
    TreeNode Deserialize(String str){
        if(str == null){
            return null;
        }
        String[] arr = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        return deSerialize(queue);
    }
    private TreeNode deSerialize(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#")){//字符串比较用equals不能使用==
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deSerialize(queue);
        node.right = deSerialize(queue);
        return node;
    }

}
