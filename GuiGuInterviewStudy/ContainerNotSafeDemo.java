import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-05-08  01:42
 * @description: 集合类不安全的问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {

        System.out.println("=========ArrayList的安全性分析==============");
        /*
        List<String> list = Arrays.asList("a","b","c");
        list.forEach(System.out::println);
        */
        /*
        list.add("a");
        list.add("b");
        list.add("c");
        for (String element:list) {
            System.out.println(element);
        }
        */

        //List<String> list = new ArrayList<>();

        //List<String> list = new Vector<>();

        //List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        /**
         * 1.故障异常
         *  java.util.ConcurrentModificationException 并发修改异常
         *
         * 2.导致原因
         *  并发争抢修改导致，导致我们花名册签名的情况
         *  一个人正在写，另一个过来抢夺，导致数据不一致异常。===> 并发修改异常
         *
         * 3.解决方案
         *  3.1 new Vector<>();
         *  3.2 Collections.synchronizedList(new ArrayList<>());
         *  3.3 new CopyOnWriteArrayList(); 写时复制
         *
         * 4.优化建议
         *  写时复制
         *
         */
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("=========HashSet的安全性分析==============");

        Set<String> set = new HashSet<>(); //出现java.util.ConcurrentModificationException
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
        //Set<String> set = new CopyOnWriteArraySet<>(); //底层是CopyOnWriteArrayList
        for (int i = 1; i <= 30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }


        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("=========HashMap的安全性分析==============");

        //Map<String,String> map = new HashMap<>();//出现java.util.ConcurrentModificationException
        //Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 30 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }







    }
}
