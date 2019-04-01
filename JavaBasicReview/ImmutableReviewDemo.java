import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  15:22
 * @description: 对于集合类型，可以使用 Collections.unmodifiableXXX() 方法来获取一个不可变的集合。
 */
public class ImmutableReviewDemo {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a",1);
    }
}
