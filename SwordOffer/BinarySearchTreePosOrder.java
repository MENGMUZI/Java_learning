/**
 * @author : mengmuzi
 * create at:  2019-03-27  22:59
 * @description: 二叉搜索树的后序遍历序列
 */
public class BinarySearchTreePosOrder {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length < 1){
            return false;
        }
        return judgeSquenceOfBST(sequence,0,sequence.length-1);

    }

    private boolean judgeSquenceOfBST(int[] sequence, int start, int end) {
        if(start >=end){
            return true;
        }
        int index = start;
        while (sequence[index] < sequence[end] && index < end){
             index++;
        }
        for (int i = index; i <end ; i++) {
            if(sequence[i] < sequence[end]){
                return false;
            }

        }
        return judgeSquenceOfBST(sequence,start,index-1) && judgeSquenceOfBST(sequence,index,end-1);
    }

}
