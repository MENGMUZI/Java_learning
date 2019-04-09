import java.util.*;


/**
 * @author : mengmuzi
 * create at:  2019-04-09  21:51
 * @description: Map容器的复习
 */
public class MapReviewDemo {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList();
        //使用集合存储list中每个元素出现的个数
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer temp:list) {
            Integer count = map.get(temp);
            map.put(temp,(count == null) ? 1 : count +1);
        }


        //对map的key排序，可以使用TreeMap
        Map<Integer,Integer> sortMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);//升序
            }
        });

        //对map中的value值排序
        List<Map.Entry<Integer,Integer>> linkedList = new LinkedList<>(map.entrySet());
        Collections.sort(linkedList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<Integer,Integer> result = new LinkedHashMap<>();//排序完的集合
        for (Map.Entry<Integer,Integer> entry: linkedList) {
            result.put(entry.getKey(),entry.getValue());
        }


    }

}
