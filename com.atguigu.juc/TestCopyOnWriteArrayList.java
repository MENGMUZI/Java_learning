import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : mengmuzi
 * create at:  2019-05-24  01:53
 * @description:  CopyOnWriteArrayList/CopyOnWriteSet 写时复制
 *                注意：添加操作多时，效率低；因为每次添加都会进行复制，开销非常大。并发迭代操作多，可以提高效率。
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        ListThread lt = new ListThread();
        for (int i = 1; i <= 10 ; i++) {
            new Thread(lt).start();
        }
    }
}

class  ListThread implements Runnable{
    //private static List<String> list = Collections.synchronizedList(new ArrayList<>());//java.util.ConcurrentModificationException
    private static List<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }
    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("mengmuzi");
        }
    }
}
