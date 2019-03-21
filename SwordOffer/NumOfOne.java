/**
 * @author : mengmuzi
 * create at:  2019-03-20  15:51
 * @description: 二进制中1的个数
 */
public class NumOfOne {
    //方法一：用一个flag和原始的数相与
    public int NumberOf1(int n){
        int count = 0;//1的个数
        int flag = 1;//比较的标准
        while(flag != 0){ // 移到位数溢出的时候结束
            if((n & flag) != 0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }
    //方法二：
    /*
    * 把一个整数减去一，再和原数做与运算，把整数最右边的1的变成0，有多少个1就可以进行
    * 多少次操作
    * */
    public int NumberOf2(int n){
        int count = 0;
        while(n !=0){
            n = (n-1) & n;
            count++;
        }
        return count;
    }

}
