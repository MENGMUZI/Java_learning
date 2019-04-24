import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : mengmuzi
 * create at:  2019-04-25  01:15
 * @description: 多线程下迭代器的弱一致性的效果。
 */
public class CopyOnWriteArrayListTest2 {

    private static volatile CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        copyOnWriteArrayList.add("mengmuzi");
        copyOnWriteArrayList.add("is");
        copyOnWriteArrayList.add("a");
        copyOnWriteArrayList.add("SouthEast");
        copyOnWriteArrayList.add("University");
        copyOnWriteArrayList.add("student");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                ///修改list中下标为0的元素为muzi
                copyOnWriteArrayList.set(0,"muzi");
                //删除元素
                copyOnWriteArrayList.remove(3);
                copyOnWriteArrayList.remove(4);
            }
        });
        //保证在修改线程启动前获取迭代器
        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        //启动线程
        threadOne.start();
        //等待子线程执行完毕
        threadOne.join();
        //迭代元素
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }




}
