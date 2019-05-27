/**
 * @author : mengmuzi
 * create at:  2019-05-21  16:59
 * @description: 100以内的质数
 */
public class PrimeNumberTest {

    public static void main(String[] args) {
        primeNumber01();
        primeNumber02();

    }

    private static void primeNumber02() {
        System.out.println("100以内的质数有：");
        long start = System.currentTimeMillis();
        label: for (int i = 2; i <= 10000 ; i++) {
            for (int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0){
                    continue label;
                }
            }
            System.out.print(i + "\t");

        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start) + "ms");

    }

    public static void primeNumber01() {
        System.out.println("100以内的质数有：");
        long start = System.currentTimeMillis();
        for (int i = 2; i <= 10000 ; i++) {
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i) ; j++){//优化二：改成开方
                if(i % j == 0){
                    flag = false;
                    break;//优化一：添加break
                }
            }
            if(flag){
                System.out.print(i + "\t");
            }
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("花费的时间：" + (end - start) + "ms");
    }

}
