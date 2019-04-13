import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  16:00
 * @description: FileOutputStream的用法
 */
public class FileOutputStreamReview {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("/Users/mengmuzi/Desktop/我的凉经.docx");
            fileOutputStream = new FileOutputStream("/Users/mengmuzi/Desktop/我的凉经副本.docx");
            byte[] b = new byte[1024];
            int nums;
            while((nums=fileInputStream.read(b))>0){
                fileOutputStream.write(b,0,nums);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

}
