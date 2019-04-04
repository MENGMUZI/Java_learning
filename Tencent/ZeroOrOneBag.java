/**
 * @author : mengmuzi
 * create at:  2019-04-04  22:35
 * @description: 0-1背包问题
 */
public class ZeroOrOneBag {

    static int n;//物品的个数
    static int c;//背包的容量
    static int[] value; //描述商品的价值
    static int[] weight;//商品的重量

    public static void main(String[] args) {
        value = new int[]{1500,3000,2000};
        weight= new int[]{1,4,3};
        c = 4;
        n = 3;
        //构造最优解的网格：3行4列
        int[][] maxValue = new int[n][c];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <c ; j++) {
                maxValue[i][j] = 0;
            }
        }
        //填充网格
        for (int i = 0; i <n ; i++) {//商品的个数
            for (int j = 1; j <=c ; j++) {//对应每个背包的容量
                if(i == 0){
                    maxValue[i][j-1] = weight[i] <= j ? value[i] : 0;
                }else{
                    int topValue = maxValue[i-1][j-1];//上一个网格的值
                    int thisValue = weight[i] <= j ? (j- weight[i] > 0 ? value[i]+maxValue[i-1][j-weight[i]] : value[i]) : topValue;
                    //返回这两个中的最大值
                    maxValue[i][j-1] = thisValue > topValue ? thisValue : topValue;
                }
            }
        }
        //打印结果的二维数组
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <c ; j++) {
                System.out.print(maxValue[i][j] + " ");
            }
            System.out.println();

        }
    }

}
