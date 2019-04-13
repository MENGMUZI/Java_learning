import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  15:19
 * @description: 使用FileInputStream字节流读取文件：
 */
public class FileInputStreamReview {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        try{
            //创建字节输入流
            fileInputStream = new FileInputStream("/Users/mengmuzi/Desktop/我的凉经.docx");
            //创建一个长度为1024的字节数组
            byte[] bytes = new byte[1024];
            //用于保存的实际字节数
            int nums;
            //使用循环重复取字节
            while((nums = fileInputStream.read(bytes))>0){
                System.out.println(new String(bytes,0,nums));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
    }
}
