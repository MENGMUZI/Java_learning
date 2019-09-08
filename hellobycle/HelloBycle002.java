/**
 * @author : mengmuzi
 * create at:  2019-09-05  19:59
 * @description: 小哈计算器
 */
public class HelloBycle002 {
    private static int specialCalculator(String expr){
        int rst = 0;
        char[] exprArr = expr.toCharArray();
        for (int i = 0; i <exprArr.length-1 ; i++) {
            if(exprArr[i] == '+'){
                rst = (exprArr[i-1]-'0') + (exprArr[i+1]-'0');
                exprArr[i+1] = (char)(rst +'0');
            }
            if(exprArr[i] == '-'){
                rst = (exprArr[i-1]-'0') - (exprArr[i+1]-'0');
                exprArr[i+1] = (char)(rst +'0');
            }
            if(exprArr[i] == '*'){
                rst = (exprArr[i-1]-'0') * (exprArr[i+1]-'0');
                exprArr[i+1] = (char)(rst +'0');
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int rst = specialCalculator("3-3*7+1");
        System.out.println(rst);
    }

}
