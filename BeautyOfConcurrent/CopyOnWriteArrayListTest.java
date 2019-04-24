import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  00:49
 * @description: 弱一致性的迭代器
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("hello");
        copyOnWriteArrayList.add("mengmuzi");
        //采用迭代器
        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
