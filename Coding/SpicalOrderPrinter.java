/**
 * @author : mengmuzi
 * create at:  2019-03-15  09:56
 * @description: 转圈打印矩阵
 */
public class SpicalOrderPrinter {

    public static void spicalOrderPrint(int[][] matrix) {

        int tR = 0;//矩阵的左上角的行
        int tC = 0;//左上角的列

        int dR = matrix.length - 1;//右下角的行
        int dC = matrix[0].length - 1;//右下角的列

        while(tR <= dR && tC <= dC){
            printEdgeByCircle(matrix,tR++,tC++,dR--,dC--);
        }
    }

    private static void printEdgeByCircle(int[][] matrix, int tR, int tC, int dR, int dC) {

        //子矩阵只有一行
        if(tR == dR){
            for (int i = tC; i <= dC; i++){
                System.out.print(matrix[tR][i] + " ");
            }
        }
        //子矩阵只有一列
        else if(tC == dC){
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        }
        else{
            int curC = tC;
            int curR = tR;
            while (curC != dC){
                System.out.print(matrix[tR][curC++] + " ");
            }
            while (curR != dR){
                System.out.print(matrix[curR++][dC] + " ");
            }
            while (curC != tC){
                System.out.print(matrix[dR][curC--] + " ");
            }
            while (curR != tR){
                System.out.print(matrix[curR--][tC] + " ");
            }

        }

    }

    public static void main(String[] args) {
        //int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr ={{1}};
        spicalOrderPrint(arr);
    }
}
