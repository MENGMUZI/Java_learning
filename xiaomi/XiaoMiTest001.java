/**
 * @author : mengmuzi
 * create at:  2019-09-11  19:40
 * @description:
 */
import java.util.Scanner;

public class XiaoMiTest001 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void solution(String[] input) {
        if(input == null){
            return;
        }
        for (int i = 0; i < input.length; i++) {
            String[] chars = input[i].split(" ");
            for (int j = 0; j < chars.length -1; j++) {
                Integer p1 = Integer.parseInt(chars[j]);
                Integer p2 = Integer.parseInt(chars[j+1]);
                if(p1 == p2 && p1 != 0){
                    chars[j] = String.valueOf(p1 + p2);
                    chars[j+1] = String.valueOf(0);
                }
            }

            StringBuffer sb = new StringBuffer();
            int count = 0;
            for (int j = 0; j < chars.length ; j++) {
                if(!chars[j].equals("0")){
                    sb.append(chars[j]).append(" ");
                }else{
                    count ++;
                }
            }
            while (count --> 0){
                sb.append("0").append(" ");
            }
            System.out.println(sb);

        }



    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        solution(_input);
    }
}

