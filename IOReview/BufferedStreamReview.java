import java.io.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-13  16:11
 * @description: 字节缓存流的用法
 */
public class BufferedStreamReview {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try{
            //创建字节输入流
            fileInputStream = new FileInputStream("/Users/mengmuzi/Desktop/我的凉经.docx");
            //创建字节输出流
            fileOutputStream = new FileOutputStream("/Users/mengmuzi/Desktop/我的凉经1.docx");
            //创建字节缓存输入流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            //创建字节缓存输出流
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] b = new byte[1024];
            int nums;
            while((nums = bufferedInputStream.read(b))>0){
                bufferedOutputStream.write(b,0,nums);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();//会自动帮助关闭下层的流
        }
    }

}
