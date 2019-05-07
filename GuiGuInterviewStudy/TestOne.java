/**
 * @author : mengmuzi
 * create at:  2019-05-07  17:00
 * @description: 自增方法的反编译
 */
public class TestOne {
    volatile int n = 0;
    public void add(){
        n++;
    }
/**
 *        2: getfield      #2                  // Field n:I
 *        5: iconst_1
 *        6: iadd
 *        7: putfield      #2                  // Field n:I
 *
 *
 * */
    public static void main(String[] args) {

    }
}
