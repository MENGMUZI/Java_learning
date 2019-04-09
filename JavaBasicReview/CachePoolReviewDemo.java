/**
 * @author : mengmuzi
 * create at:  2019-04-09  13:34
 * @description: valueOf() 方法的实现比较简单，就是先判断值是否在缓存池中，如果在的话就直接返回缓存池的内容。
 */
public class CachePoolReviewDemo {
    public static void main(String[] args) {
        poolCacheTest();
    }

    private static void poolCacheTest() {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);//false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);//true


    }

}
