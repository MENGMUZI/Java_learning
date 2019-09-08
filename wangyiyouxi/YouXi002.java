import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-09-07  19:20
 * @description:
 */
public class YouXi002 {
    static class TreeNode {
        private final int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int group = scanner.nextInt();
        for (int groupIndex = 0; groupIndex < group ; groupIndex++) {
            int nums = scanner.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < nums; i++) {
                List<Integer> elementList = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    elementList.add(scanner.nextInt());
                }
                list.add(elementList);
            }
            Set<Integer> set = new HashSet<>();
            //找出根节点；
            for (int i = 0; i < nums; i++) {
                List<Integer> help = new ArrayList<>();
                help = list.get(i);
                for (int j = 1; j <= 2; j++) {
                    int tmp = help.get(j);
                    if (tmp != -1) {
                        set.add(tmp);
                    }
                }
            }
            int rootNode = 0;
            for (int i = 0; i < nums; i++) {
                if (set.contains(i)) {
                    continue;
                }else{
                    rootNode = i;
                    break;
                }
            }

            //构建这棵树的结构
            //根节点对应的值
            int rootValue = list.get(rootNode).get(0);
            TreeNode root = new TreeNode(rootValue);
            createTree(list,root,rootNode);
            //二叉树按层遍历
            boolean flag = lsyerTravel(root);
            if(flag){
                System.out.println("YES");

            }else{
                System.out.println("NO");
            }
        }

    }

    private static void createTree(List<List<Integer>> list, TreeNode root,int rootNode){
        int leftNum = 0;
        int rightNum = 0;
        leftNum = list.get(rootNode).get(1);
        root.setLeft(new TreeNode(list.get(leftNum).get(0)));
        rightNum = list.get(rootNode).get(2);
        root.setRight(new TreeNode(list.get(rightNum).get(0)));
        createTree(list,root.getLeft(),leftNum);
        createTree(list,root.getRight(),rightNum);
        if(leftNum == -1 || rightNum == -1){
            return;
        }
    }


    public static boolean lsyerTravel(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int toBeVisit = 1;
        int nextLevel = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //存储每个节点的值
        List<Integer> list = new LinkedList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.getValue());
            if(temp.left != null){
                nextLevel ++;
                queue.offer(temp.left);
            }
            if(temp.right != null){
                nextLevel ++;
                queue.offer(temp.right);
            }

            toBeVisit --;
            if(toBeVisit == 0){
                List<Integer> l = new LinkedList<>();
                l.addAll(list);
                result.add(l);
                toBeVisit = nextLevel;
                nextLevel = 0;
                list.clear();

            }

        }
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i <result.size() ; i++) {
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(i);
            }
            sumList.add(sum);
        }

        //判断是否递增
        boolean flag = true;
        for (int i = 0; i <sumList.size()-1 ; i++) {
            if(sumList.get(i) < sumList.get(i+1)){
                flag = true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
