import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : mengmuzi
 * create at:  2019-04-14  17:05
 * @description:
 */
public class CollectionTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        List<Integer> synlist = (List<Integer>) Collections.synchronizedList(list);
        List<Integer> cowlist = new CopyOnWriteArrayList<>();
        List<Integer> linkedlist = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> currmap = new ConcurrentHashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();


    }

}
