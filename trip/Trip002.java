/**
 * @author : mengmuzi
 * create at:  2019-09-04  19:56
 * @description:
 */

import java.util.Scanner;

public class Trip002 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        if(expr == null || expr == ""){
            return "";
        }
        int leftNum = 0;
        int rightNum = 0;
        for (int i = 0; i < expr.length(); i++) {

            if (expr.charAt(i) == '(') {
                leftNum ++;
            }
            if(expr.charAt(i) == ')'){
                rightNum ++;
            }

        }
        if(leftNum != rightNum){
            return "";

        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) != ')') {
                sb.append(expr.charAt(i));
            } else {
                int j = 0;
                for (j = expr.charAt(i); j >= 0 && expr.charAt(j) == '('; j--) {

                }
                String subStr = sb.substring(j + 1, i);
                StringBuffer subStrBuff = new StringBuffer(subStr);
                subStrBuff = subStrBuff.reverse();
                sb.delete(j, i);
                sb.append(subStrBuff);
            }

        }
        expr = new String(sb);
        if (expr.contains(")")) {
            resolve(expr);
        }
        return expr;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

