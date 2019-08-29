/**
 * @author : mengmuzi
 * create at:  2019-08-29  23:54
 * @description:
 */
class Student {

    public Student(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String name;

    public int age;

    private String phone;

    public String getPhone() {
        return phone;
    }

}

public class Person01{

    public static void main(String[] args) {

        Student student = new Student("mmz",23,"12323124");

        student.age = 24;

        student.getPhone();

    }

}
