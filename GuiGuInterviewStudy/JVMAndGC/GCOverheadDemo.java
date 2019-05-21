package JVMAndGC;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-05-14  21:34
 * @description:  GC overhead limit exceeded
 *               JVM参数配置演示
 *               -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m
 *
 */
public class GCOverheadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try{
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Exception e){
            System.out.println("**********i:" + i);
            e.printStackTrace();
            throw e;
        }//Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    }

}
