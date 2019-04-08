import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Coding1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int scale = Integer.parseInt(sc.nextLine());

        List<int[]> numList = new ArrayList<int[]>();
        int size = 0;

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line == null || line.equals("")){
                break;
            }

            String[] numStrs = line.split(",");

            int[] nums = new int[numStrs.length];

            for(int i = 0; i < numStrs.length; i++){
                nums[i] = Integer.parseInt(numStrs[i]);
            }

            numList.add(nums);
            size += numStrs.length;
        }

        int result[] = new int[size];
        int index = 0;
        int round = 0;
        int mark = 0;


        while(index < size){
            int[] nums = numList.get(round);

            for(int i = 0; i < scale; i ++){
                if(mark + i < nums.length && index < size){
                    result[index] = nums[mark + i];
                    index++;
                }
            }

            round++;
            if(round >= numList.size()){
                round = 0;
                mark += scale;
            }
        }
        System.out.println(Arrays.toString(result));
        for (int i = 0; i <result.length-1 ; i++) {
            System.out.print(result[i]+",");
        }
        System.out.println(result[result.length-1]);

    }
}