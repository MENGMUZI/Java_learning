import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-04-10  22:14
 * @description: 泛型的复习
 */
public class GenericReviewDemo {
    //泛型类
    static class Box<T>{
        private T t;
        public void set(T t){
            this.t = t;
        }
        public T get(){
            return t;
        }
    }

    static class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key , V value){
            this.key = key;
            this.value = value;
        }
        public void setKey(K key){
            this.key = key;
        }
        public void setValue(V value1){
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
    //泛型方法
    public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2){
        return (p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue()));
    }

    //通配符
     class Fruit{};
     class Apple extends Fruit{};
     class Orange extends Fruit{};
     static class GenericReading{
        static List<Apple> apples = Arrays.asList(new Apple[10]);
        static List<Orange> oranges = Arrays.asList(new Orange[10]);
        static List<Fruit> fruits = Arrays.asList(new Fruit[10]);
        static class Reader<T>{
            T readExect(List<? extends T> list){
                return list.get(0);
            }
        }
        static void function1(){
            Reader<Fruit> reader = new Reader<>();
            Fruit f = reader.readExect(apples);//List一定要使用通配符 List<? extends T>
        }
    }
    //PECS原则
    public static void main(String[] args) {
        Box<Integer> boxInt = new Box<>();
        Box<Double> boxDou = new Box<>();
        Box<String> boxStr = new Box<>();
        Pair<String,Integer> p1 = new Pair<>("mengmuzi",24);
        Pair<String,Integer> p2 = new Pair<>("GuMin",25);
        boolean flag = GenericReviewDemo.compare(p1,p2);
        System.out.println(flag);

        List<? extends Fruit> fruitsList = new ArrayList<Apple>();
        // fruitsList.add(new GenericReviewDemo().new Apple());
        fruitsList.add(null);
        Fruit f = fruitsList.get(0);

    }
}
