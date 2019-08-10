import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-04-10  19:37
 * @description:
 */
public class HHWW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while(scanner.hasNextLine()){
            String str = scanner.next();
            Stack<Character> stack = new Stack<>();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i <str.length() ; i++) {
                list.add(str.charAt(i));
            }
            for (int i = 0; i <list.size() ; i++) {
                if( list.get(i).equals('}') || list.get(i).equals(']') || list.get(i).equals(')')){
                    StringBuffer buffer = new StringBuffer();
                    StringBuffer buffer2 = new StringBuffer();
                    while(!stack.isEmpty() && !(stack.peek().equals('{') || stack.peek().equals('[') || stack.peek().equals('('))){
                        buffer.append(stack.pop());
                    }
                    stack.pop();
                    int time = stack.pop()-48;
                    for (int j = 0; j <time ; j++) {
                        buffer2 = buffer2.append(buffer);

                    }
                    String push = buffer2.reverse().toString();
                    for (int j = 0; j <push.length() ; j++) {
                        stack.add(push.charAt(j));
                    }
                }else{
                    stack.add(list.get(i));
                }
            }
            while(! stack.isEmpty()){
                System.out.print(stack.pop());
            }

        }
        
    }

}
