/**
 * @author : mengmuzi
 * create at:  2019-05-04  00:40
 * @description: 0-N中1出现的次数，什么时候f(n) = n;
 */
public class OneTurns {
    public static void main(String[] args) {
        int n = 2;
        int res = 1;
        while((getOnly(n) + res)!= n){
            res += getOnly(n);
            ++ n;
        }
        System.out.println(n);


    }

    static int getOnly(int num){
        int number = 0;
        String s = num + "";
        int len = s.length();
        if(len != 0){
            for (int i = 0; i <len ; i++) {
                if(s.charAt(i) == '1'){
                    number ++;
                }
            }
        }
        return number;
    }

}
