/**
 * @author : mengmuzi
 * create at:  2019-03-20  11:14
 * @description: 斐波那契数列
 */
public class FibonacciArray {
    //递归的方式（时间复杂度2的N次方）
    public int Fibonacci1(int n){
        if (n ==0) {
            return 0;
        }
        if (n ==1){
            return 1;
        }
        return Fibonacci1(n-1) + Fibonacci1(n-2);
    }
    //遍历的方式（时间复杂度是N）
    public int Fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int sum = 0;
        int before = 0;
        int curr = 1;
        if (n > 2) {
            for (int i = 1; i < n; i++) {
                sum = before + curr;
                before = curr;
                curr = sum;
            }
        }
        return sum;

    }
    //尾递归版本
    public int Fibonacci3(int n){

       return Fibonacci(n,0,1);
    }
    private int Fibonacci(int n,int curr,int next){
        if(n ==0){return 0;}
        if(n ==1){return next;}
        else return Fibonacci(n-1,next,curr+next);
    }


}
