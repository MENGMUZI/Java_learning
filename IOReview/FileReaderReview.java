import java.io.FileReader;
import java.io.IOException;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  15:49
 * @description: 使用字符流FileReader读取文件
 */
public class FileReaderReview {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        try{
            //创建字符输入流
            fileReader = new FileReader("/Users/mengmuzi/Desktop/我的凉经.docx");
            //创建一个长度为1024字符数组
            char[] chars = new char[1024];
            //用于保存实际字符数
            int nums;
            while((nums = fileReader.read(chars))>0){
                System.out.println(new String(chars,0,nums));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            fileReader.close();
        }
    }

}
