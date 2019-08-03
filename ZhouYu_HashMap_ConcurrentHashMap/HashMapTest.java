import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : mengmuzi
 * create at:  2019-07-09  21:07
 * @description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("1","2");
        //put方法返回值为null或者value；如果key没有重复，put成功，则返回null
        //如果key重复了，返回的是map.get(key)，也就是当前这个key对应的value
        String value = hashMap.put("1","3");
        System.out.println(value);
    }

}
