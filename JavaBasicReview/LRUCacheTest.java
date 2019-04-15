import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : mengmuzi
 * create at:  2019-04-15  03:24
 * @description: 使用 LinkedHashMap 实现的一个 LRU 缓存：
 * 设定最大缓存空间 MAX_ENTRIES 为 3；
 * 使用 LinkedHashMap 的构造函数将 accessOrder 设置为 true，开启 LRU 顺序；
 * 覆盖 removeEldestEntry() 方法实现，在节点多于 MAX_ENTRIES 就会将最近最久未使用的数据移除。
 */
public class LRUCacheTest<K,V> extends LinkedHashMap<K,V> {

    private static final int MAX_ENTRIES = 3;
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest){
        return size() > MAX_ENTRIES;
    }
    LRUCacheTest(){
        super(MAX_ENTRIES,0.75f,true);
    }

    public static void main(String[] args) {
        LRUCacheTest<Integer,String>  cache = new LRUCacheTest<>();
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");
        cache.put(4,"d");
        System.out.println(cache.get(1));//null
        cache.get(3);//4, 3, 5]
        cache.put(5,"e");
        System.out.println(cache.keySet());//[3, 4, 5]


    }

}
