/**
 * @author : mengmuzi
 * create at:  2019-05-08  20:12
 * @description: 值传递
 */
class PersonOne{
    int age;
    String name;

    public PersonOne(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class TestTransferValue {
    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(PersonOne personOne){
        personOne.setName("xxx");
    }
    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue testTransferValue = new TestTransferValue();
        int age = 20;
        testTransferValue.changeValue1(age);
        System.out.println("age----" + age);
        //age----20

        PersonOne personName = new PersonOne("abc");
        testTransferValue.changeValue2(personName);
        System.out.println("personName-----" + personName.getName());
        //personName-----xxx

        String str = "abc";
        testTransferValue.changeValue3(str);
        System.out.println("String-----" + str);
        //String-----abc

    }
}
