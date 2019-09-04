import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-09-01  20:55
 * @description:
 */
public class TXXX002 {

    static class Person {
        int a;
        int b;
        Person(int aa, int bb) {
            a = aa;
            b = bb;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            int aa = scanner.nextInt();
            int bb = scanner.nextInt();
            persons[i] = new Person(aa, bb);
        }

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (-o1.a + o2.a + o1.b - o2.b);
            }
        });

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long) persons[i].a * (long) (i) + (long) persons[i].b * (long) (n - i - 1));
        }
        System.out.println(ans);

    }

}
