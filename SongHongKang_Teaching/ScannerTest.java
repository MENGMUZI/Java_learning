import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-05-21  14:58
 * @description: 键盘获取值
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println(name);

        System.out.println("请输入你的年龄：");
        int num = scanner.nextInt();
        System.out.println(num);

        System.out.println("请输入你的体重：");
        double weight = scanner.nextDouble();
        System.out.println(weight);

        System.out.println("请输入你的意愿：");
        boolean isLove = scanner.nextBoolean();
        System.out.println(isLove);

    }


}
