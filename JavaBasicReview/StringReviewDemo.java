/**
 * @author : mengmuzi
 * create at:  2019-03-26  01:05
 * @description: String的复习
 */
public class StringReviewDemo {
    public static void main(String[] args) {
        //stringReviewConstructor1();
        //stringReviewConstructor2();
        //stringReviewConstructor3();
        //stringMethodConstructor4();
        //stringMethodConstructor5();
        stringMethodConstructor6();
    }
    //字符数组转化成字符串
    private static void stringReviewConstructor1(){
        char[] arr = {'m','e','n','g'};
        //String s = new String(arr);
        String s = new String(arr,1,3);
        System.out.println("s="+s);
    }
    //字节数组转化为字符串
    private static void stringReviewConstructor2(){
        String s = new String();//等效于String s = " "; 而不是String s = null;
        byte[] arr = {65,97,99,100};//注意byte是小写，65对应A；97对应a
        String s1 = new String(arr);
        System.out.println("s1="+s1);
    }
    //String类的不可变性
    private static void stringReviewConstructor3(){
        String s = "mengmuzi";//创建一个字符串对象在常量池中
        String s1 = new String ("mengmuzi");//创建了2个对象
        String s2 = s1;
        System.out.println(s == s1);//false
        System.out.println(s.equals(s1));//true,string中复写了equals方法
        System.out.println(s == s2);//false
        System.out.println(s1 == s2);//true
    }
    //String类中的方法
    private static void stringMethodConstructor4(){
        String s = "abcdeabdcabc";
        System.out.println("length：" + s.length());
        System.out.println("char:" + s.charAt(0));//根据下标获取字符
        System.out.println("index:" + s.indexOf('a') );//0 ; 根据字符找下标
        System.out.println("index:" + s.indexOf('m') );//-1; 找不到返回-1
        System.out.println("lastIndex:" + s.lastIndexOf('a'));//9 ;找最后一个出现的字符
        System.out.println("substring:" + s.substring(2,4));//字符串中的子序列
    }
    private static void stringMethodConstructor5(){
        //字符串变成字符串数组
        String s = "孟木子，顾敏，木子，敏";
        String[] arr = s.split(",");
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        //字符串变成字符数组
        char[] chs = s.toCharArray();
        for (int i = 0; i <chs.length ; i++) {
            System.out.print(chs[i]+"#");
        }
        System.out.println();
        //字符串变成字节数组
        s = "孟木子";
        byte[] bytes = s.getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.print(bytes[i]+"#");
        }
        System.out.println();
        //字符串中的字母转成大小写
        s = "mengmuzi";
        System.out.println(s.toUpperCase());
        String s1 = "NBA,CBA";
        System.out.println(s1.toLowerCase());
        //将字符串中的字母替换
        s = "muzi";
        System.out.println(s.replace("m","mengm"));//可以放字符串
        System.out.println(s.replace('m','n'));//也可以放字符
        //将字符串的两端的空格去掉
        s = " meng mu zi";
        System.out.println(s.trim());
        //将字符串进行连接
        s = "meng";
        s1 = "gu";
        System.out.println((s.concat(s1)).equals(s+s1));//true
        System.out.println(s.concat(s1) == s+s1);//false
    }
    //判断2个字符串的关系
    private static void stringMethodConstructor6(){
        String s = "mengmuzi";
        System.out.println(s.equals("MENGMUZI".toLowerCase()));
        //忽略大小写
        System.out.println(s.equalsIgnoreCase("MENGMUZi"));//忽略大小写的比较
        //字符串中是否包含指定的字符串
        System.out.println(s.contains("zi"));//true
        //字符串是否以指定字符开头或者结尾
        String s1 = "MENGmuzi.163@com";
        System.out.println(s1.startsWith("MEN"));//true
        System.out.println(s1.endsWith("com"));//true
    }


}
