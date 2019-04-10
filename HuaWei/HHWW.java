import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-04-10  18:53
 * @description:
 */
public class HHWW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int nums = scanner.nextInt();
            List<String> list = new ArrayList<>();
            String[] arrs = new String[nums];
            for (int i = 0; i <nums ; i++) {
                arrs[i] = scanner.next();
            }
            for (int i = 0; i <arrs.length ; i++) {
                String str = arrs[i];
                while(str.length() > 8){
                    list.add(str.substring(0,8));
                    str = str.substring(8);
                }
                int len = str.length();
                StringBuffer sb = new StringBuffer(str);
                for (int j = 0; j <8-len ; j++) {
                    sb.append("0");
                }
                list.add(sb.toString());
            }
            Collections.sort(list);
            for (String element : list) {
                System.out.print(element + " ");
            }
        }

    }

}
