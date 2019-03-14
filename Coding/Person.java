import java.util.Objects;

/**
 * @author : mengmuzi
 * create at:  2019-03-14  10:38
 * @description:
 */
public class Person implements Comparable{

    private String name;

    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        //首先强转
        Person person = (Person)o;
        //比较主要条件
        int temp = this.age - person.age;
        //若主要条件一致，在比较次要条件
        return temp == 0 ? this.name.compareTo(person.name):temp;//这里的compareTo是字符串的比较
    }
}
