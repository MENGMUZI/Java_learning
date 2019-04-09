import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  10:02
 * @description: Collections 工具类常用方法
 */
public class CollectionsReviewDemo {

    public static void main(String[] args) {
        //collectionShowI();
        //collectionShowII();
        collectionShowIII();
    }

    private static void collectionShowIII() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(3);
        list.add(3);
        list.add(-5);
        list.add(7);
        list.add(4);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(-1);
        Map<String,Integer> map = new HashMap<>();
        map.put("Java",88);
        map.put("Python",90);

        //Collections.emptyXXX();创建一个空的、不可改变的XXX对象
        List<Object> emptyList = Collections.emptyList();
        System.out.println(emptyList);//[]
        Set<Object> objects = Collections.emptySet();
        System.out.println(objects);//[]
        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        System.out.println(objectObjectMap);//{}

        //Collections.singletonXXX();
        List<List<Integer>> arrayLists = Collections.singletonList(list);
        System.out.println(arrayLists);
        Set<List<Integer>> singleton = Collections.singleton(list);
        System.out.println(singleton);//[[-1, 3, 3, -5, 7, 4, -9, -7]]
        Map<String, String> nihao = Collections.singletonMap("1", "nihao");
        System.out.println(nihao);//{1=nihao}

        //unmodifiableXXX();创建普通XXX对象对应的不可变版本
        List<Integer> integers = Collections.unmodifiableList(list);
        System.out.println(integers);
        integers.add(-1);//Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println(integers);
        Set<Integer> integers2 = Collections.unmodifiableSet(hashSet);
        System.out.println(integers2);//[1, 2, 3]
        Map<Object, Object> objectObjectMap2 = Collections.unmodifiableMap(map);
        System.out.println(objectObjectMap2);//{Java=82, 语文=80}


    }

    private static void collectionShowII() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(3);
        list.add(3);
        list.add(-5);
        list.add(7);
        list.add(4);
        list.add(10);
        list.add(6);
        System.out.println(list);
        //找出最大值
        System.out.println(Collections.max(list));
        //最小是
        System.out.println(Collections.min(list));
        //用新元素替换旧元素
        Collections.replaceAll(list,3,-3);
        System.out.println(list);
        //统计元素出现的频率
        System.out.println(Collections.frequency(list,-3));
        //统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
        List<Integer> subList = new ArrayList<>();
        subList.add(-5);
        subList.add(7);
        subList.add(4);
        System.out.println(Collections.indexOfSubList(list,subList));
        // 对List进行二分查找，返回索引，List必须是有序的
        Collections.sort(list);
        System.out.println();
        System.out.println(Collections.binarySearch(list,10));

    }

    private static void collectionShowI() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(3);
        list.add(3);
        list.add(-5);
        list.add(7);
        list.add(4);
        System.out.println(list);
        //反转list
        Collections.reverse(list);
        System.out.println(list);
        //旋转(当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。)
        Collections.rotate(list,4);
        System.out.println(list);
        //自然排序升序
        Collections.sort(list);
        System.out.println(list);
        //随机排序
        Collections.shuffle(list);
        System.out.println(list);
        //交换两个索引的位置
        Collections.swap(list,0,5);
        System.out.println(list);
        //定制排序用法
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//降序排列
            }
        });
        System.out.println(list);

    }


}
