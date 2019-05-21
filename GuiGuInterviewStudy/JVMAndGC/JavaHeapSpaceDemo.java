package JVMAndGC;
import java.util.Random;
/**
 * @author : mengmuzi
 * create at:  2019-05-14  21:24
 * @description:  JavaHeapSpace
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[80 * 1024 * 1024 * 1024];

        String str = "mengmuzi";
        while(true){
            str += str + new Random().nextInt(111111) + new Random().nextInt(22222222);
            str.intern();//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        }
    }
}
