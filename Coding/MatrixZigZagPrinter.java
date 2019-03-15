/**
 * @author : mengmuzi
 * create at:  2019-03-15  12:51
 * @description: 之字形打印矩阵
 */
public class MatrixZigZagPrinter {
    
    public static void printMatrixZigZag(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;
        boolean frombottletotop = true;
        while(tR <= endR ){
            printlineByOrder(matrix,tR,tC,dR,dC,frombottletotop);
            tR = tC == endC? tR+1 : tR;
            tC = tC == endC? tC : tC+1;

            dC = dR == endR? dC+1 : dC;
            dR = dR == endR? dR : dR+1;
            frombottletotop = !frombottletotop;
        }
    }

    private static void printlineByOrder(int[][] matrix, int tR, int tC, int dR, int dC, boolean frombottletotop) {
        if(frombottletotop){
            while(dR >= tR){
                System.out.print(matrix[dR--][dC++]+" ");
            }
        }else{
            while(tR <= dR){
                System.out.print(matrix[tR++][tC--]+" ");
            }
        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixZigZag(arr);
    }


}
