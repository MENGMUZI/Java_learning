import org.junit.Test;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  18:37
 * @description:
 */
public class GetMInStackTest {
    @Test

    public static void main(String[] args){
        GetMinStack gms = new GetMinStack();
        int[] arr = {5,11,7,9,6,12,3};
        for(int i = 0; i < arr.length ; i++){
            gms.push(arr[i]);
        }
        System.out.println("最小值："+gms.getmin());
    }

}
