/**
 * @author : mengmuzi
 * create at:  2019-05-03  16:54
 * @description:
 */
public class ValueTest {
    class Value{
        public int i = 15;
    }

    public static void main(String[] args) {
        ValueTest value = new ValueTest();
        value.first();
    }

    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.println(v.i + " " + i);// 20 ,5
    }

    private void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);// 15 ,0
    }

}
