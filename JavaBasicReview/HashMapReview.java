import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : mengmuzi
 * create at:  2019-04-15  19:14
 * @description: HashMap复习
 */
public class HashMapReview {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        //键不能重复，值可以重复
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");//老王被覆盖
        map.put("lao", "老王");
        System.out.println("-----------------------输出hashmap---------------------");
        System.out.println(map);

        /**
         * 遍历HashMap
         * */
        //1.获取Map中的所有键
        System.out.println("---------------------获取map中的所有键-----------------------");
        Set<String> keys = map.keySet();
        for (String element : keys) {
            System.out.print(element + " ");
        }
        System.out.println();
        //2.获得Map中的所有值
        System.out.println("---------------------获取map中的所有值-----------------------");
        Collection<String> values = map.values();
        for (String element : values) {
            System.out.print(element + " ");
        }
        System.out.println();
        //3.得到key的值的同时得到key所对应的值
        System.out.println("---------------------得到key的值的同时得到key所对应的值-----------------------");
        Set<String> keys2 = map.keySet();
        for (String element: keys2) {
            System.out.print(element + ":" + map.get(element) + " ");
        }
        System.out.println();


        /**
         * 另外一种不常用的遍历方式
         */
        // 当我调用put(key,value)方法的时候，首先会把key和value封装到
        // Entry这个静态内部类对象中，把Entry对象再添加到数组中，所以我们想获取
        // map中的所有键值对，我们只要获取数组中的所有Entry对象，接下来
        // 调用Entry对象中的getKey()和getValue()方法就能获取键值对了
        System.out.println("---------------------另一种遍历方式-----------------------");
        Set<Map.Entry<String,String>> entrys = map.entrySet();
        for (Map.Entry<String,String> entry: entrys) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
        System.out.println();


        /**
         * HashMap其他常用方法
         */
        System.out.println("after map.size()："+map.size());// 5
        System.out.println("after map.isEmpty()："+map.isEmpty());// false
        System.out.println(map.remove("san"));
        System.out.println("after map.remove()："+map);
        System.out.println("after map.remove()："+map.get("san"));// null
        System.out.println("after map.get(si)："+map.get("si")); // 李四
        System.out.println("after map.containsKey(si)："+map.containsKey("si")); //true
        System.out.println("after containsValue(李四)："+map.containsValue("李四")); //true
        System.out.println(map.replace("si", "李四2"));
        System.out.println("after map.replace(si, 李四2):"+map);
    }

}
