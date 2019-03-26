/**
 * @author : mengmuzi
 * create at:  2019-03-26  20:43
 * @description: 一个子串在一个整串中出现的次数
 */
/*
* "acasdmengqhwdhqmuabskdmengbsadiasmengasbdia"
* 思路：首先要找这个子串是否有，用indexof
*
* */
public class JavaStringReviewTest2 {

    public static void main(String[] args) {
        String str = "acasdmengqhwdhqmuabskdmengbsadiasmengasbdia";
        String key = "meng";
        int result = getKeyStringCount(str,key);
        System.out.println(key +" 在 " + str + " 中出现了 "+result+" 次");
    }
    private static int getKeyStringCount(String str, String key){
        int result = 0;
        int index = 0;
        if(!str.contains(key)){
            return 0;
        }
        while((index = str.indexOf(key)) != -1){
            result++;
            str = str.substring(index + key.length());
        }
        return result;
    }


}
