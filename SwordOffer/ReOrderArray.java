/**
 * @author : mengmuzi
 * create at:  2019-03-20  19:03
 * @description: 调整数组顺序使奇数位于偶数的前面
 */
public class ReOrderArray {

    public static void reOrderArray(int[] array){
        if(array.length <= 1){
            return;
        }
        for(int i = 1; i < array.length; i++){
            for(int j= i;  j>0; j--){
                if ((array[j]&0x1)==1 && (array[j-1]&0x1)==0){
                    swap(array, j,j-1);
                }
            }
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;

        //可以用异或装逼
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]);
        }
    }
}
