import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author : mengmuzi
 * create at:  2019-08-20  15:00
 * @description:
 */
public class YouZan01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str == null || str.equals("")){
            System.out.println("");
            return;
        }
        String[] arr = str.split("\\|");
        if(arr == null || arr.equals("")){
            System.out.println("");
            return;
        }
        String[] listArr01 = null;
        String[] listArr02 = null;
        if(arr[0] != null){
            listArr01 = arr[0].split(",");
        }
        if(arr[1] != null){
            listArr02 = arr[1].split(",");
        }
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < listArr01.length ; i++) {
            treeSet.add(listArr01[i]);
        }
        for (int i = 0; i < listArr02.length ; i++) {
            treeSet.add(listArr02[i]);
        }
        System.out.println(treeSet);
    }

}
