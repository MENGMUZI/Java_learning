/**
 * @author : mengmuzi
 * create at:  2019-03-19  21:34
 * @description: 替换空格
 */
public class ExchangeBlank {

    public String replaceSpace(StringBuffer str) {

        return str.toString().replaceAll(" ","%20");

    }

    public String replaceSpace2 (StringBuffer str){
        String newStr = str.toString();
        char[] arr = newStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==' '){
                sb.append("%20");
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

}
