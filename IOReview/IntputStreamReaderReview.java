import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  16:29
 * @description: 转换流的使用
 * java使用System.in代表输入。即键盘输入，
 * 但这个标准输入流是InputStream类的实例，使用不太方便，
 * 而且键盘输入内容都是文本内容，所以可以使用InputStreamReader
 * 将其包装成BufferedReader,利用BufferedReader的readLine()方法
 * 可以一次读取一行内容
 */
public class IntputStreamReaderReview {
    public static void main(String[] args) {
        try{
            //将System.in对象转化为Reader对象
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            //将普通的Reader包装成BufferedReader
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String buffer = null;
            while((buffer = bufferedReader.readLine())!= null){
                // 如果读取到的字符串为“exit”,则程序退出
                if(buffer.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入内容："+buffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{

        }
    }
}
