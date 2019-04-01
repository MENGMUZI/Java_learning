import java.util.Random;

/**
 * @author : mengmuzi
 * create at:  2019-04-01  22:17
 * @description: 由 Rand5 实现 Rand7
 */
public class Rand5ToRand7 {

    //用Math.random()产生一个1-5的随机数
    public int rand1To5(){
        return (int)(Math.random() * 5 ) + 1;
    }
    //用Random产生一个1-5的随机数
    public int rand1To5II(){
        Random random =new Random();
        return random.nextInt(5) + 1;
    }
    //用rand1To5产生rand1To7
    public int rand1To7(){
        int num = 0;
        do{
            num = (rand1To5() -1) * 5 + rand1To5() -1;
        }while (num > 20);
        return num % 7 +1;
    }
    public static void main(String[] args) {
        Rand5ToRand7 example = new Rand5ToRand7();
        int result = example.rand1To5();
        int otherresult = example.rand1To5II();
        int rand7result = example.rand1To7();
        System.out.println("result: " + result);
        System.out.println("otherresult: " + otherresult);
        System.out.println("1To7result: " + rand7result);
    }

}
