/**
 * @author : mengmuzi
 * create at:  2019-04-09  15:01
 * @description: 字符串常量池
 */
public class StringPoolReviewDemo {
    public static void main(String[] args) {
        //String s1 = new String("aaa");
        //String s2 = new String("aaa");
        //System.out.println(s1 == s2);//false
        //String s3 = s1.intern();
        //String s4 = s1.intern();
        //String s5 = s2.intern();
        //System.out.println(s3 == s4);//true
        //System.out.println(s5 == s3);//true
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        String str1 = "bbb";
        String str2 = "bbb";
        String str3 = new String("bbb");
        String str4 = str3.intern();
        System.out.println("str4 : str3" + str4 == str3);//false
        System.out.println("str4 : str1" + str4 == str2);//false
        System.out.println(str1 == str2);//true

        System.out.println("||||||||||||||||||||||||||||||||||||||||");
        String s = new String("1");
        //s.intern();
        s = s.intern();
        String ss = "1";
        System.out.println(s == ss);//false;true

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
        String s1 = "Rakesh";
        String s2 = "Rakesh";
        String s3 = "Rakesh".intern();
        String s4 = new String("Rakesh");
        String s5 = new String("Rakesh").intern();


        if ( s1 == s2 ){
            System.out.println("s1 and s2 are same");  // 1.
        }

        if ( s1 == s3 ){
            System.out.println("s1 and s3 are same" );  // 2.
        }

        if ( s1 == s4 ){
            System.out.println("s1 and s4 are same" );  // 3.
        }

        if ( s1 == s5 ){
            System.out.println("s1 and s5 are same" );  // 4.
        }

    }

}
