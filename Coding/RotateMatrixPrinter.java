/**
 * @author : mengmuzi
 * create at:  2019-03-15  11:09
 * @description: 正方形矩阵旋转90度打印
 */
public class RotateMatrixPrinter {
    public static int[][] rotateMatrix(int[][] matrix){
        int tR = 0; //矩阵的左上角的行
        int tC = 0; //左上角的列

        int dR = matrix.length - 1;//右下角的行
        int dC = matrix[0].length - 1;//右下角的列

        while(tR <= dR && tC <= dC){
            ratateEdgeByCircle(matrix,tR++,tC++,dR--,dC--);
        }
        return matrix;
    }
    private static void ratateEdgeByCircle(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC -tC;//选取旋转点的次数
        for (int i = 0; i < times; i++) {//这里不能采用while里面搞自增的方法，循环交换的时候会出现错误角标越界
            int temp = matrix[tR][tC+i];
            matrix[tR][tC+i] = matrix[dR-i][tC];
            matrix[dR-i][tC] = matrix[dR][dC-i];
            matrix[dR][dC-i] = matrix[tR+i][dC];
            matrix[tR+i][dC] = temp;
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] newarr = rotateMatrix(arr);
        for (int i = 0; i <newarr.length ; i++) {
            for (int j = 0; j <newarr[i].length; j++) {
                System.out.print(newarr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
