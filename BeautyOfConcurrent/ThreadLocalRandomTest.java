import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : mengmuzi
 * create at:  2019-04-24  20:39
 * @description: 为了弥补多线程高并发情况下Random的缺陷 ,在JUC包下新增了ThreadLocalRandom类
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        //获取一个随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();
        //输出10个在0-5 (包含0，不包含5)之间的随机数
        for (int i = 0; i <10 ; i++) {
            System.out.println(random.nextInt(5));
        }
    }

}
