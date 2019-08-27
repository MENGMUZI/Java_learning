/**
 * @author : mengmuzi
 * create at:  2019-08-26  01:08
 * @description:
 */
public class KStest {

    public static void main(String[] args) {
        String str = "+123";
        int val = Integer.valueOf(str);
        System.out.println(val);

        System.out.println("================");
        int val02 = Integer.valueOf(str.charAt(0));
        System.out.println(val02);

        System.out.println("=================");
        String str01 = "";
        String str02 = "";
        System.out.println(str01 == str02);

        System.out.println("=================");
        String str03 = null;
        String str04 = null;
        System.out.println(str01 == str03);//false
        System.out.println(str03 == str04 );
        System.out.println("=================");

        String s1 = new String("mengmuzi");
        String s2 = "mengmuzi";
        System.out.println(s1 == s2);//false
        System.out.println("=================");

        String s3 = new String("mengmuzi");
        s3 = s3.intern();        String s4 = "mengmuzi";
        System.out.println(s3 == s4);//true
        System.out.println("=================");

        char[] c = {'a','b','c','d'};
        String s = "abcd";
        char[] cc = s.toCharArray();
        System.out.println(c == cc);//false
        System.out.println(c.equals(cc));//false


    }


}
