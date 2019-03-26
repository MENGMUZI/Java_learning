/**
 * @author : mengmuzi
 * create at:  2019-03-26  20:06
 * @description: String类精华练习题
 */
/*
* 给定一个字符串数组，按照字典顺序进行从小到大排序
* {"nba","cba","wnba","fifa","ucaa","abl","lol","MBA"}
* */
public class JavaStringReviewTest1 {

    public static void main(String[] args) {
        String[] arr = {"nba","cba","wnba","fifa","ucaa","abl","lol","mba"};
        sortString(arr);
        printArray(arr);
    }

    private static void printArray(String[] arr) {
        System.out.print("{");
        for (int i = 0; i <arr.length ; i++) {
            if(i != arr.length-1) {
                System.out.print(arr[i] + ",");
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.print("}");
    }

    private static void sortString(String[] arr){
        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i ; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
