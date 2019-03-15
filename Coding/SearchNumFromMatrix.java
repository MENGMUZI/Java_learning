/**
 * @author : mengmuzi
 * create at:  2019-03-15  15:41
 * @description: 从行列排好序的数组中找数
 */
public class SearchNumFromMatrix {

    public static boolean isContains(int[][] matrix, int num){
        int row = 0;//选取一个基准点（假如是右上角）
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(num > matrix[row][col]){
                row++;
            }
            else if(num < matrix[row][col]){
                col--;
            }
            else{
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,2,5,4},{5,6,2,8},{9,7,11,12}};
        boolean torf = isContains(arr,6);
        System.out.println("isContains?????    "+torf);
    }


}
