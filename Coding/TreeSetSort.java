import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  12:56
 * @description:
 */
public class TreeSetSort {

    public static void main(String[] args){
        TreeSet treeset = new TreeSet(new ComparatorByName());
        treeset.add(new Person("mengmuzi",18));
        treeset.add(new Person("muzi",17));
        treeset.add(new Person("gumin",19));
        treeset.add(new Person("min",19));
        treeset.add(new Person("min",20));
        treeset.add(new Person("min",21));

        Iterator iterator = treeset.iterator();

        while(iterator.hasNext()){
            Person p = (Person) iterator.next();
            System.out.println(p.getName()+":"+p.getAge());
        }
    }

}
