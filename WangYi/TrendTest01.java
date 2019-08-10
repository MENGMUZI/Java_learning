import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-08  18:46
 * @description:
 */
public class TrendTest01 {

    private static String add(String num1, String num2) {
        if(num1 == null && num2 == null){
            return null;
        }
        if(num1 == null){
            return num2;
        }
        if(num2 == null){
            return num1;
        }
        String[] arr1 = num1.split("\\.");
        String[] arr2 = num2.split("\\.");
        //一个加数切分下来
        String start1 = arr1[0];
        String end1 = arr1[1];
        //第二个加数切分下来
        String start2 = arr2[0];
        String end2 = arr2[1];

        String start = utillAdd(start1,start2);
        String end = utillAdd(end1,end2);

        String result = start+"."+end;
        while(result.charAt(result.length()-1) == '0'){
            result = result.substring(0,result.length()-1);
        }
        return result;



    }

    private static String utillAdd(String a, String b){
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = aArr.length - 1;
        int j = bArr.length - 1;
        int count = 0;
        while(i >= 0 || j >= 0){
            int temp = 0;
            if(i < 0){
                temp = bArr[j--] + count - '0';
            }
            if(j < 0){
                temp = aArr[i--] + count - '0';
            }
            if(i >= 0 && j >= 0){
                temp = aArr[i--] + bArr[j--] + count - 2 * '0';
            }
            if(temp > 9){
                count = 1;
                temp -= 10;
            }else {
                count = 0;
            }
            sb.append(temp);
            if(i<0 && j<0 && count==1){
                sb.append(count);
            }
        }
        return sb.reverse().toString();

    }

    // please don't modify any code below.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }

}

