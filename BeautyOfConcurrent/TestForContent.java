/**
 * @author : mengmuzi
 * create at:  2019-04-24  11:36
 * @description: 单线程下多个变量被放入同一个缓存行对性能有影响
 */
public class TestForContent {

    static final int LINE_NUM = 1024;
    static final int COLUM_NUM = 1024;

    public static void main(String[] args) {
        long[][] array = new long[LINE_NUM][COLUM_NUM];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <LINE_NUM ; ++i) {
            for (int j = 0; j <COLUM_NUM; ++j) {
                array[i][j] = i * 2 + j;
            }
        }
        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time:" + cacheTime);
    }

}
