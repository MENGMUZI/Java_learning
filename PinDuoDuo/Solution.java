import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  16:50
 * @description:
 */
public class Solution {

    int n =5;
    int m = 4;
    boolean[][] a;
    HashSet<String> set;
    ArrayList<String> list;
    int phead,ptail;
    StringBuilder end;
    boolean stop = false;

    public static void main(String[] args){
        Solution s = new Solution();
        int[] xi = {1,2,3,3};
        int[] yi = {3,3,4,5};
        s.hill(xi,yi);
    }
    public void hill(int[] xi,int[] yi){
        a = new boolean[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j <n+1 ; j++) {
                a[i][j] = false;
            }
        }
        for (int i = 1; i < n+1 ; i++) {
            a[0][i] =true;
        }
        for (int i = 0; i <m ; i++) {
            a[xi[i]][yi[i]] = true;
        }

        set = new HashSet<String>();
        list = new ArrayList<String>(1000);
        StringBuilder start = new StringBuilder("1");
        for (int i = 0; i <n ; i++) {
            start.append("0");
        }
        end = new StringBuilder("1");
        for (int i = 0; i <n ; i++) {

        }
    }

}
