import java.awt.*;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-19  18:53
 * @description:
 */
public class SenseTime01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int w1 = scanner.nextInt();
        int h1 = scanner.nextInt();

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int w2 = scanner.nextInt();
        int h2 = scanner.nextInt();

        Rectangle re1 = new Rectangle(x1, y1, w1, h1);
        Rectangle re2 = new Rectangle(x2, y2, w2, h2);
        //得到交集
        Rectangle inter = re1.intersection(re2);
        if (inter == null || inter.isEmpty()) {
            System.out.println("null");
            return;
        }

        //交集的坐标
        int X = inter.x;//水平坐标
        int Y = inter.y;//垂直坐标

        //交集宽高
        int W = inter.width;//交集的宽
        int H = inter.height;//交集的高

        System.out.println(X + " " + Y + " " + W + " " + H + " ");


    }

}
