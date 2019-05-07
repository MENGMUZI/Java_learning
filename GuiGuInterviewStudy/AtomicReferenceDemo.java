import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : mengmuzi
 * create at:  2019-05-07  23:17
 * @description: 原子引用
 */
class User{
    String username;
    int age;

    User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User mmz = new User("mengmuzi",23);
        User faker = new User("lixianghe",20);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(mmz);
        System.out.println(atomicReference.compareAndSet(mmz,faker) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(mmz,faker) + "\t" + atomicReference.get().toString());
    }

}
