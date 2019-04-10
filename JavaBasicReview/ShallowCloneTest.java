/**
 * @author : mengmuzi
 * create at:  2019-04-10  13:19
 * @description:
 */
public class ShallowCloneTest {
    public static void main(String[] args) {

            ShallowCloneExampleDemo sc = new ShallowCloneExampleDemo();
            ShallowCloneExampleDemo sc2 = null;
            try {
                sc2 = sc.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            sc.set(2,222);
            System.out.println(sc2.get(2));//222


    }

}
