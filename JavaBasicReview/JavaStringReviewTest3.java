/**
 * @author : mengmuzi
 * create at:  2019-03-26  21:04
 * @description: 两个字符串中最大相同的子串
 */
/*
* "guminmengmuizyiqinvlixuexi"
* "ruguobunvlimengmuzijiumeiyougongzuo"
*
* */
public class JavaStringReviewTest3 {

    public static void main(String[] args) {
        String str1 = "guminmengmuziyiqinvlixuexi";
        String str2 = "ruguobunvlimengmuzijiumeiyougongzuo";
        String res = getMaxSubString(str1,str2);
        System.out.println(res);
    }

    private static String getMaxSubString(String str1, String str2) {
        String minStr = (str1.length() > str2.length())? str2 : str1;
        String maxStr = (str1 == minStr) ? str2 : str1 ;
        String sub = new String();
        String maxSub = new String();
        for (int start = 0; start < minStr.length() ; start++) {
            for (int end = minStr.length(); end > start ; end--) {
                sub = minStr.substring(start,end);
                if(maxStr.contains(sub)){
                    maxSub = (maxSub.length()< sub.length())? sub : maxSub;
                }
            }
        }
        return maxSub;
    }

}
