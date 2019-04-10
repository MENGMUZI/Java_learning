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

    public static void main(String[] args) {
        Box<Integer> boxInt = new Box<>();
        Box<Double> boxDou = new Box<>();
        Box<String> boxStr = new Box<>();
        Pair<String,Integer> p1 = new Pair<>("mengmuzi",24);
        Pair<String,Integer> p2 = new Pair<>("GuMin",25);
        boolean flag = GenericReviewDemo.compare(p1,p2);
        System.out.println(flag);

    }
}
