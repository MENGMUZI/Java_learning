/**
 * @author : mengmuzi
 * create at:  2019-03-26  22:07
 * @description: StringBuffer的常用方法
 */
public class JavaStringBufferReviewDemo {
    public static void main(String[] args) {
        stringBufferConstrustor1();

    }
    private static void stringBufferConstrustor1(){
        //1.添加功能
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer("meng");
        sb.append("mu");
        sb1.append(" mu zi");
        System.out.println(sb);
        System.out.println(sb1);
        //2.插入功能
        sb1.insert(5,"hhaha");
        System.out.println(sb1);
        //3.删除功能
        StringBuffer sb3 = new StringBuffer("mengmuzi");
        sb3.delete(1,3);//注意删的是end-1
        System.out.println(sb3);
        sb3.deleteCharAt(0);//删除指定位置的数
        System.out.println(sb3);
        //4.修改功能
        StringBuffer sb4= new StringBuffer("mengmuziheihei");
        sb4.replace(0,1,"gu");//同样不包括end
        System.out.println(sb4);
        //5.查找功能
        StringBuffer sb5 = new StringBuffer("mengmuzi啊哈哈");
        int index = sb5.lastIndexOf("i");
        System.out.println(index);
        //6.获得子串
        StringBuffer sb6 = new StringBuffer("mengmuzi啊哈哈");
        String sub = sb6.substring(0,5);
        System.out.println(sub);
        System.out.println(sub.toString());
        //7.字符串反转
        StringBuffer sb7 = new StringBuffer("mengmuzi啊哈哈");
        System.out.println(sb7.reverse());

    }
}
