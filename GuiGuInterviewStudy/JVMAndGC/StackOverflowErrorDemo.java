package JVMAndGC;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  21:18
 * @description:  StackOverflowError
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();//Exception in thread "main" java.lang.StackOverflowError
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }

}
