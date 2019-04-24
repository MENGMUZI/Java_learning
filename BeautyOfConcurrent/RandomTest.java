import java.util.Random;

/**
 * @author : mengmuzi
 * create at:  2019-04-24  20:25
 * @description: java. util.Random 的使用方法
 */
public class RandomTest {
    public static void main(String[] args) {
        //创建一个默认种子的随机数生成器
        Random random = new Random();
        //输出10个在0~5 (包含0，不包含5) 之间的随机数
        for (int i = 0; i <10 ; i++) {
            System.out.println(random.nextInt(5));
        }
    }

}
