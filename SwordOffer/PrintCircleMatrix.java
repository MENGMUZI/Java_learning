import java.util.ArrayList;


/**
 * @author : mengmuzi
 * create at:  2019-03-27  02:05
 * @description: 顺时针旋转打印矩阵
 */
public class PrintCircleMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tR = 0; //矩阵的左上角的行
        int tC = 0; //左上角的列

        int dR = matrix.length - 1;//右下角的行
        int dC = matrix[0].length - 1;//右下角的列
        ArrayList<Integer> list = new ArrayList<>();
        while(tR <= dR && tC <= dC){
            list = printByOneCircle(list,matrix,tR++,tC++,dR--,dC--);
        }
        return list;
    }

    private ArrayList<Integer> printByOneCircle(ArrayList<Integer> list, int[][] matrix, int tR, int tC, int dR, int dC) {
        //子矩阵只有一行
        if(tR == dR){
            for (int i = tC; i <= dC; i++){
                list.add(matrix[tR][i]);
            }
        }
        //子矩阵只有一列
        else if(tC == dC){
            for (int i = tR; i <= dR; i++) {
                list.add(matrix[i][tC]);
            }
        }
        else{
            int curC = tC;
            int curR = tR;
            while (curC != dC){
                list.add(matrix[tR][curC++]);
            }
            while (curR != dR){
                list.add(matrix[curR++][dC]);
            }
            while (curC != tC){
                list.add(matrix[dR][curC--]);
            }
            while (curR != tR){
                list.add(matrix[curR--][tC]);
            }

        }
        return list;

    }

}
