/**
 * @author : mengmuzi
 * create at:  2019-04-10  01:38
 * @description:
 */
public class SuperExtendClassDemo extends SuperUsingReviewDemo{

    private int z;

    public SuperExtendClassDemo(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public void func() {
        super.func();
        System.out.println("child func is running!!");
    }

    public static void main(String[] args) {
        SuperExtendClassDemo secd = new SuperExtendClassDemo(1,2,3);
        secd.func();
    }
}
